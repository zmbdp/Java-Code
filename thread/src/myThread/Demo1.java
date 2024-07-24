package myThread;
// 实现 Runnable（ruan的bou） 接口
class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello Runnable");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
// 继承 Thread（死ruai的） 类
class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello Thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        // Thread
        MyThread myThread = new MyThread();
        myThread.start();
        /*=========================================*/
        // Runnable
        MyRunnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();
        /*=========================================*/
        while (true) {
            System.out.println("Hello Main");
            Thread.sleep(1000);
        }
    }
}
