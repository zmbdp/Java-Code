package myThread;

public class Demo19 {
    public static Object locker1 = new Object();
    public static Object locker2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2) {
                    System.out.println("t1 *2");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (locker1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (locker2) {
                    System.out.println("t2 *1");
                }
            }
        });
        t1.start();
        t2.start();

    }
}
