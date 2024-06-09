import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][][] f = new int[n + 1][k + 2][8];
        String str = sc.next();
        int mod = 998244353;
        f[0][1][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k + 1; j++) {
                for (int l = 0; l < 8; l++) {
                    if (l == 6) {
                        continue;
                    }
                    if ((l % 2 == 1) != (str.charAt(i - 1) == '1')) {
                        f[i][j][l] = (f[i - 1][j - 1][l / 2] + f[i - 1][j - 1][(l / 2) + 4]) % mod;
                    }
                    else {
                        f[i][j][l] = (f[i - 1][j][l / 2] + f[i - 1][j][(l / 2) + 4]) % mod;
                    }
                }
            }
        }
        int as = 0;
        for (int i = 1; i <= k + 1; i++) {
            for (int j = 0; j <= 7; j++) {
                if (j != 6) {
                    as = (as + f[n][i][j]) % mod;
                }
            }
        }
        System.out.println(as);
    }
}
