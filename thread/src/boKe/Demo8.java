package boKe;

public class Demo8 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int i = 0;
            while (i++ < 5) {
                System.out.println("Hello t1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 结束了!!!");
        });

        Thread t2 = new Thread(() -> {
            int i = 0;
            while (i++ < 3) {
                System.out.println("Hello t2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 结束了!!!");
        });
        t1.start();
        t2.start();
    }
}
