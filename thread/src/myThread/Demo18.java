package myThread;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
// 线程池
class MyThreadPool {
    BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    public void submit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }
    public MyThreadPool(int n) {
        for (int i = 0; i < n; i++) {
            // n 表示线程池里面有几个线程，把 run 任务丢给这些线程执行，给 n 个线程执行
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        // 领取任务，执行任务
                        queue.take().run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }
}

public class Demo18 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool pool = new MyThreadPool(4);
        for (int i = 0; i < 1000; i++ ){
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "->hello");
                }
            });
        }
    }
}
