package myThread;


// 还有 callable（kao勒bou） ，线程池 来创建线程
// 使用 lambda(拉姆达) 表达式
public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("Hello Thread");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // setDaemon：设定这个线程是否为后台线程，true 表示是，false 表示是前台
        // t.setDaemon(true);
        t.start();
        int i = 0;
        while (i++ <= 5) {
            System.out.println("Hello Main");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
