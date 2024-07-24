package myThread;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo13 {
    public static volatile BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    volatile public static int a = 0;
    public static void main(String[] args) {
        //BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
        //BlockingQueue <String> queue = new PriorityBlockingQueue<>();
        Thread t1 = new Thread(() -> {
            while (true) {
                if (a == 0) {
                    System.out.print("请输入->");
                }
                try {
                    String pt = new Scanner(System.in).nextLine();
                    if (a != 0){
                        System.out.print("请输入->");
                    }
                    queue.put(pt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a++;
            }
        });

        Thread t2 = new Thread(() -> {
            while (true){
                try {
                    String ret = queue.take();
                    System.out.println("你输入的是->" + ret);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
