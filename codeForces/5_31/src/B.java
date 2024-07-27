import java.util.Scanner;

public class B {
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long m = sc.nextInt();
        if (m == 0) {
            System.out.println(n);
            return;
        }
        long a = (Math.max((n - m), 0L)) ^ n;
        long b = (n + m) ^ n;
        long x = Math.max(a, b);
        int i = 0;
        while (true) {
            if ((1L << i) <= x) {
                n = n | (1L << i);
            }
            else {
                break;
            }
            i++;
        }
        System.out.println(n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            solve();
        }
    }
}
