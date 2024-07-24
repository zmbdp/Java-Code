package boKe;

public class Demo7 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });

        t.start();
        Thread.sleep(3000);
        // interrupt 方法会将上一个标志位变成 true，并且强制唤醒正在 sleep 的线程
        // 这时候想要退出 t 线程，只需要在 catch 的地方加入 break 就好了，
        // 还可以不立即退出，做一些其他的工作再退出也行，可供程序猿选择
        t.interrupt();
        System.out.println("线程结束!!!");
    }
}
