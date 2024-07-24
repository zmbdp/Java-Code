package myThread;

import java.util.Scanner;

// 内存可见性引起的线程安全问题
public class Demo9 {
    // volatile: 因为读取内存中的 a 操作被优化了，读的是寄存器的值
    //           添加这个关键字，可以给编译器提醒这个属性以后可会改变，就不会把读操作给优化掉
    //private static volatile int a = 0;
    private static int a = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (a == 0) {
                // 使用 sleep，可以线程主动放弃当前cpu时间片，让其他线程有机会执行。
                //      *+=+*+=+*这种操作会强制线程重新从主内存中读取变量的值*+=+*+=+*
                // 而不是从线程私有的工作内存中读取，从而防止编译器对代码进行优化，保证变量值的及时更新。
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t1 输出完毕!!!");
        });

        Thread t2 = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入 a 的值->");
            a = sc.nextInt();
            System.out.println("t2 输入完毕!!!");
        });

        t1.start();
        t2.start();
    }
}
