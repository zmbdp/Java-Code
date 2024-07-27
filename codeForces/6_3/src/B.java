import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class B {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int f = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[105];

            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }

            int x = a[f];
            Arrays.sort(a);
            int[] b = new int[a.length];
            for (int y : a) {
                b[]
            }
            if (a[k] == x && a[k + 1] == x) {
                System.out.println("MAYBE");
            } else if (a[k] > x) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

        scanner.close();
    }
}
