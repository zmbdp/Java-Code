/*
import java.util.Comparator;
import java.util.PriorityQueue;

// 描述一个定时器
class MyTimerTask {
    // 一个定时器得有 run 方法， 得有过多久执行这个程序的 'time' ，就是过多久执行这个线程
    volatile private Runnable runnable;
    volatile private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }
}
// 优先级队列添加定时器
class MyTimer {
    volatile PriorityQueue<MyTimerTask> queue = new PriorityQueue<>(new Comparator<MyTimerTask>() {
        @Override
        public int compare(MyTimerTask o1, MyTimerTask o2) {
            return (int) (o1.getTime() - o2.getTime());
        }
    });
    public void schedule(Runnable runnable, long delay) {
        synchronized (this){
            // 先创建一个线程
            MyTimerTask myTimerTask = new MyTimerTask(runnable, delay);
            // 把线程添加进优先级队列中
            queue.offer(myTimerTask);
            // 添加好了元素，休眠结束
            this.notify();
        }
    }

    // 计算多久开始执行这个线程
    public MyTimer() {
        // 创建线程
        Thread thread = new Thread(() -> {
            while (true) {
                synchronized (this){
                    try {
                        // 如果队列为空，则开始休眠，一直休眠到添加进元素之后在开始执行
                        while (queue.isEmpty()) {
                            this.wait();
                        }
                        // 先算出时间
                        // 程序开始执行的时间减去当前真实的时间，如果小于等于 0 ，就必须开始执行了
                        long differenceTime = queue.peek().getTime() - System.currentTimeMillis();
                        if (differenceTime <= 0) {
                            queue.poll().getRunnable().run();
                        } else {
                            // 如果进来了，说明大于 0 ，就等这么久
                            this.wait(differenceTime);
                        }

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.start();
    }
}

public class MyTimerTool {
    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2");
            }
        }, 2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3");
            }
        }, 1000);

        System.out.println("Main");
    }
}*/


import java.util.Comparator;
import java.util.PriorityQueue;

// 描述一个定时器
class MyTimerTask {
    // 定时器得要一个 run 方法，还得有一个时间 time
    volatile private Runnable runnable;
    volatile private long time;

    public MyTimerTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public long getTime() {
        return time;
    }
}

// 优先级队列添加定时器
class MyTimer {
    volatile private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>(new Comparator<MyTimerTask>() {
        @Override
        public int compare(MyTimerTask o1, MyTimerTask o2) {
            return (int) (o1.getTime() - o2.getTime());
        }
    });

    // 等待多久执行任务
    public MyTimer() {
        // 先创建一个线程
        Thread thread = new Thread(() -> {
            while (true) {
                synchronized (this) {
                    try {
                        while (queue.isEmpty()) {
                            this.wait();
                        }
                        // 用户输入的时间减去实际的时间，如果小于等于 0，则开始执行任务
                        long differenceTime = queue.peek().getTime() - System.currentTimeMillis();
                        if (differenceTime <= 0) {
                            queue.poll().getRunnable().run();
                        } else {
                            // 如果进来了，说明大于 0 ，就等这么久
                            this.wait(differenceTime);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    // 添加定时器进入优先级队列
    public void schedule(Runnable runnable, long delay) {
        synchronized (this) {
            queue.offer(new MyTimerTask(runnable, delay));
            // 添加好了一个就结束睡眠
            this.notify();
        }
    }
}

public class MyTimerTool {
    public static void main(String[] args) {
        MyTimer myTimer = new MyTimer();
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello 1");
            }
        }, 3000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello 2");
            }
        }, 2000);
        myTimer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello 3");
            }
        }, 1000);

        System.out.println("Main 结束");
    }
}


























