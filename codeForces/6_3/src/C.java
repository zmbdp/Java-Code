import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    public static int N = (int) (1e6 + 5);
    public static int[] a = new int[N];
    public static int[] b = new int[N];
    public static int n, m ,k;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        while (T-- > 0) {
            n = scanner.nextInt();
            Map<Integer, Integer> vis = new HashMap<>();

            for (int i = 1; i <= n; ++i) {
                a[i] = scanner.nextInt();
            }

            for (int i = 1; i <= n; ++i) {
                b[i] = scanner.nextInt();
            }

            m = scanner.nextInt();
            int ed = 0;
            boolean flag = false;

            for (int i = 1; i <= m; ++i) {
                ed = scanner.nextInt();
                vis.put(ed, vis.get(ed) + 1);
            }

            for (int i = 1; i <= n; ++i) {
                if (b[i] == ed) {
                    flag = true;
                }
                if (a[i] == b[i]) {
                    continue;
                }
                if (!vis.containsKey(b[i])) {
                    System.out.println("NO");
                    return;
                }
                vis.put(b[i], vis.get(b[i]) - 1);
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }
}