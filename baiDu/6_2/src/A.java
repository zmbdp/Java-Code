import java.util.Arrays;
import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        long as = 0L;
        Scanner sc = new Scanner(System.in);
        long N = sc.nextInt();
        long B = sc.nextInt();
        long[] p = new long[(int) N];
        long[] s = new long[(int) N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        long[] arr = new long[(int) N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[j] = p[j] + s[j];
            }
            arr[i] = (p[i] / 2) + s[i];
            Arrays.sort(arr);
            long sum = 0L;
            for (int j = 0; j < N; j++) {
                sum += arr[j];
                if (sum <= B) {
                    as = Math.max(as, (j + 1));
                }
                else {
                    break;
                }
            }
        }
        System.out.println(as);
    }
}
