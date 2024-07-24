package boKe;

import java.util.Scanner;
// volatile
public class Demo11 {
    volatile public static int flag = 1;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (flag == 1) ;
            System.out.println("循环结束");
        });

        Thread t2 = new Thread(() -> {
            Scanner sc = new Scanner(System.in);
            flag = sc.nextInt();
        });

        t1.start();
        t2.start();
    }
}
