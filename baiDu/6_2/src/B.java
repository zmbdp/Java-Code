import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        int[] d = new int[n + 1];
        long[] arrV = new long[n + 1];
        int countP = 0;
        for (int i = 2; i < n + 1; i++) {
            if (d[i] == 0) {
                countP++;
                p[countP] = d[i] = i;
            }
            for (int j = 1; j <= countP; j++) {
                if (i * p[j] > n) {
                    break;
                }
                d[i * p[j]] = p[j];
                if (i % p[j] == 0) {
                    break;
                }
            }
        }
        arrV[1] = 1;
        int mod = 998244353;
        for (int i = 2; i <= n; i++) {
            arrV[i] = ((mod - (mod / i)) * arrV[mod % i]) % mod;
        }
        long sum = 1L;
        for (int i = 1; i < countP + 1; i++) {
            long c = 1L;
            while (c * p[i] <= n) {
                c = c * p[i];
            }
            sum = sum * c % mod;
        }
        long as = 0L;
        for (int i = 1; i < n + 1; i++) {
            as = (as + ((mod + n + 1 - i - i) * (sum * arrV[i] % mod) % mod) % mod) % mod;
        }
        System.out.println(as);
    }
}
