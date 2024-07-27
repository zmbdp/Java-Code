import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试用例的数量
        while (T-- > 0) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); // 读取 n
            long sum = 1;
            long minxn = Long.MAX_VALUE;
            long[] a = new long[n];
            long[] b = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt(); // 读取 a 数组
            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt(); // 读取 b 数组
            }

            long z = sc.nextLong(); // 读取 z
            for (int i = 0; i < n; i++) {
                long x = a[i];
                long y = b[i];
                if (x > y) {
                    long temp = x;
                    x = y;
                    y = temp;
                }
                sum += y - x;
                if (x <= z && z <= y) {
                    minxn = Math.min(minxn, 0L);
                } else {
                    minxn = Math.min(minxn, Math.min(z - x, z - y));
                }
            }
            System.out.println(sum + minxn);
        }
    }
}