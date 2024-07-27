import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            counts();
        }
    }

    private static void counts() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > max) {
                sum += max;
                max = a[i];
            }
            else {
                sum += a[i];
            }
            if (sum == max) {
                count++;
            }
        }
        System.out.println(count);
    }
}