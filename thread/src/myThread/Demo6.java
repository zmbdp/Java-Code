package myThread;

public class Demo6 {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Hello A");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                if (i == 7) {
                    break;
                }
                i++;
            }
            System.out.println("A结束了");
        });

        Thread b = new Thread(() -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Hello B");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
                if (i == 3) {
                    break;
                }
                i++;
            }
            // 如果 b 线程执行完了 a 线程没执行完，
            // 则执行到 a.join() 的时候，b 线程进入阻塞状态
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B结束了");
        });

        a.start();
        b.start();
        Thread.sleep(1000);
        a.interrupt();
    }
}