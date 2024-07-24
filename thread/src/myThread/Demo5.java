package myThread;

// 使用 Thread 自带的标志位来结束线程
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            // Thread.currentThread 就是 t
            // 只不过在创建这个 lambda 表达式的时候，这个表达式相当于是一个匿名内部类
            // 里面的相当于是构造方法，是在 t 创建好之前就创建好了的，
            // 所以是先执行表达式，这时候并没有初始化好 t
            // isInterrupted(): Thread 提供的一个标志位，
            // true 表示线程要结束，false 表示线程不结束
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
        // 把上一个标志位设置成 true
        // 会强制唤醒正在 sleep 的线程，并清除自带标志位，所以线程会继续
        // 这时候只需要在抛异常的时候直接 break 就行了
        t.interrupt();
        System.out.println("线程结束!!!");
    }
}
