package myThread;


import java.util.concurrent.atomic.AtomicInteger;

// 使用 "CAS" 原子类
public class Demo20 {
    // AtomicInteger 是一个原子类，有简单的 ++ 、 -- 操作
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // count++;
                count.getAndIncrement();
                /*
                // ++count;
                count.incrementAndGet();
                // count--;
                count.getAndDecrement();
                // --count;
                count.decrementAndGet();
                */
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // count++;
                count.getAndIncrement();
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(count.get());
    }
}
