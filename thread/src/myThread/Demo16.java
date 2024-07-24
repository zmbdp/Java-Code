package myThread;

import java.util.PriorityQueue;

// 描述一个线程的时间
class MyTimerTask implements Comparable<MyTimerTask>{
    volatile private Runnable runnable;
    volatile private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        synchronized (this){
            this.runnable = runnable;
            this.time = System.currentTimeMillis() + delay;
        }
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        // 时间小的优先级高，按照升序来排列
        return (int) (this.time - o.time);
    }
}
class MyTimer {
    volatile PriorityQueue<MyTimerTask> priorityQueue = new PriorityQueue<>(MyTimerTask::compareTo);

    // 插入方法，插入一个任务进优先级队列中去
    public void schedule(Runnable runnable, long delay) {
        synchronized (this){// 先创建出一个定时器元素
            MyTimerTask task = new MyTimerTask(runnable, delay);
            // 插入元素
            priorityQueue.offer(task);
            // 每次来新的任务都唤醒一下，重新更新等待时间
            this.notify();
        }
    }

    // 构造扫描线程，看看什么时候执行这个线程
    public MyTimer() {

        Thread thread = new Thread(() -> {
            // 先判断需不需要执行
            while (true) {
                try {
                    synchronized (this){
                        while (priorityQueue.isEmpty()) {
                            // 为空，直接不执行
                            this.wait();
                        }
                        // 不为空，向下走
                        // 先计算出时间差是多少，如果说小于等于零，说明执行时间到了，直接执行
                        long differenceTime = priorityQueue.peek().getTime() - System.currentTimeMillis();

                        if (differenceTime <= 0) {
                            priorityQueue.poll().getRunnable().run();

                        } else {
                            // 说明大于零，还没到执行时间，得等这么久
                            // Thread.sleep(differenceTime);
                            this.wait(differenceTime);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}

public class Demo16 {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("timer 1");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("timer 2");
            }
        }, 2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("timer 3");
            }
        }, 1000);

        System.out.println("Main");
    }
}
