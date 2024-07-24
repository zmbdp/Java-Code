package myThread;
// wait and notify
public class Demo10 {
    public static Object locker1 = new Object();
    public static Object locker2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (locker1){
                    System.out.println("t1 wait 开始");
                    try {
                        locker1.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("t1 wait 结束");
            }
        });
         Thread t2 = new Thread(() -> {
             while (true) {
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 synchronized (locker1) {
                     System.out.println("t2 notify 开始");
                     locker1.notify();
                     System.out.println("t2 notify 结束");
                 }
             }
         });
         t1.start();
         t2.start();
    }
}
