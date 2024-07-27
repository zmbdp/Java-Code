import java.util.Scanner;

public class E {
    public static int cnt(int x, int y, int z, long k) {
        int max = 0;
        for (int a = 1; a <= x; ++a) {
            if (k % a == 0) {
                long k1 = k / a;
                for (int b = 1; b <= y; ++b) {
                    if (k1 % b == 0) {
                        int c = (int) (k1 / b);
                        if (1 <= c && c <= z) {
                            int p = (x - a + 1) * (y - b + 1) * (z - c + 1);
                            max = Math.max(max, p);
                        }
                    }
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];
        for (int i = 0; i < T; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            long k = sc.nextLong();
            arr[i] = cnt(x, y, z, k);
        }
        for (int result : arr) {
            System.out.println(result);
        }
    }
}
