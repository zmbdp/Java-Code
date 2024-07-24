package myThread;

public class Demo8 {
    public int count = 0;
    Object qq = new Object();
    // synchronized: 给方法加锁
    synchronized public void add() {
            count++;
    }
    public void add2() {
        synchronized (qq) {
            count++;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Demo8 demo8 = new Demo8();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                demo8.add2();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                demo8.add2();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(demo8.count);
    }
}
