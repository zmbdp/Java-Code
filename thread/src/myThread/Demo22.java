package myThread;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

// 信号量
public class Demo22 {
    volatile private static Semaphore semaphore = new Semaphore(10);
    public static void main(String[] args) {
        // P操作，注入，所以是--
        Thread t1 = new Thread(() -> {
            while (true){
                try {
                    semaphore.acquire();
                    System.out.println("p 操作!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // V操作，释放资源，所以是++
        Thread t2 = new Thread(() -> {
            while (true) {
                int x = ((new Scanner(System.in)).nextInt());
                for (int i = 0; i < x; i++) {
                    semaphore.release();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
