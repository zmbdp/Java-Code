package myThread;

import java.util.concurrent.CountDownLatch;

// 多线程下载
public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            int id = i;
            Thread t = new Thread(() -> {
                System.out.println("线程" + id + "开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("线程" + id + "结束");
                // 每个线程的任务执行完毕之后，都会调用一下 countDown 方法
                countDownLatch.countDown();
            });
            t.start();
        }

        // await 方法一直阻塞，等到 countDown 方法执行十次之后再继续执行，表示所有线程都执行完毕了
        // a => all ，表示所有
        countDownLatch.await();
        System.out.println("多个线程执行完毕!!!");
    }
}
