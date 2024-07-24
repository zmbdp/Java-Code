package boKe;

public class Demo6 {
    public static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!flag) {
                System.out.println("Hello Thread");
            }
            System.out.println("t 线程结束");
        });

        t.start();
        Thread.sleep(3000);
        flag = true;
    }
}
