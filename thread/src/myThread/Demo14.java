package myThread;

import java.util.Scanner;

class MyBlockingQueue {
    volatile private String[] items = new String[1000];
    volatile private int head = 0;
    private int tail = 0;
    volatile private int size = 0;
    synchronized public void put(String items) throws InterruptedException {
        while (this.size >= this.items.length) {
            /*System.out.println("队列已满，不可添加!!!");
            return;*/
            this.wait();
        }
        this.items[this.tail++] = items;
        if (this.tail >= this.items.length) {
            this.tail = 0;
        }
        this.size++;
        // 现在队列不为空，直接 notify
        this.notify();
    }

    synchronized public String take() throws InterruptedException {
        while (this.size == 0) {
//            return "队列为空!!!";
            this.wait();
        }
        String ret = this.items[this.head++];
        if (this.head >= this.items.length) {
            this.head = 0;
        }
        this.size--;
        // 现在队列不是满，直接 notify
        this.notify();
        return ret;
    }
}
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        MyBlockingQueue queue = new MyBlockingQueue();

        Thread t1 = new Thread(() -> {
            try {
                int count = 0;
                while (true) {
                    //queue.put(new Scanner(System.in).nextLine());
                    queue.put(count + " ");
                    System.out.println("生产元素->" + count);
                    count++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("消费元素->" + queue.take());
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        System.out.println("Main 结束咯!!!");
    }
}
