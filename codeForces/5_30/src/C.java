import java.util.*;

public class C {
    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int compareTo(Pair other) {
            return this.first - other.first;
        }
    }

    static void YES(boolean flag) {
        if (flag) System.out.println("YES");
        else System.out.println("NO");
    }

    static final int INF = 998244353;
    static final int P = 1000000007;
    static final int N = 200005;
    static int T;
    static int n, m;
    static long[] a = new long[N];
    static long[] b = new long[N];
    static boolean[] vis = new boolean[N];
    static long[] sum = new long[N];
    static long[][] d = new long[3][N];
    static long[][] sn = new long[3][N];
    static long[][] sm = new long[3][N];

    static void solve() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n + m + 1; ++i) a[i] = sc.nextInt();
        for (int i = 1; i <= n + m + 1; ++i) b[i] = sc.nextInt();
        sn[0][0] = -1;
        sm[2][0] = -1;
        for (int i = 1; i <= n + m + 1; ++i) {
            for (int k = 0; k < 3; ++k) {
                sn[k][i] = sn[k][i - 1];
                sm[k][i] = sm[k][i - 1];
                if (sm[k][i] == m || (sn[k][i] < n && a[i] > b[i])) {
                    if (k == 1) vis[i] = false;
                    d[k][i] = a[i];
                    sn[k][i]++;
                } else {
                    if (k == 1) vis[i] = true;
                    d[k][i] = b[i];
                    sm[k][i]++;
                }
            }
        }
        d[0][n + m + 2] = d[2][n + m + 2] = 0;
        for (int i = 1; i <= n + m + 1; ++i) d[1][i] += d[1][i - 1];
        for (int i = n + m + 1; i >= 1; --i) d[0][i] += d[0][i + 1];
        for (int i = n + m + 1; i >= 1; --i) d[2][i] += d[2][i + 1];
        for (int i = 1; i <= n + m + 1; ++i) {
            long res = d[1][i - 1];
            if (!vis[i]) res += d[0][i + 1];
            else res += d[2][i + 1];
            System.out.print(res + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T-- > 0)
        {
            solve();
        }
    }
}