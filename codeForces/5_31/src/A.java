import java.util.Scanner;

public class A {
    public static int countTrailingZeros(int ans) {
        int count = 0;
        while ((ans & 1) == 0) {
            ans >>= 1;
            count++;
        }
        return count;
    }
    public static int maxScore(int l, int r) {
        int ans = 1 << (31 - Integer.numberOfLeadingZeros(r));

        if (ans < l) {
            int x = r;
            int score = 0;
            while (x > 1) {
                int p = 2;
                while (x % p!= 0)
                {
                    p++;
                }
                x /= p;
                score++;
            }
            return score;
        } else {
            return countTrailingZeros(ans);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int ret = maxScore(l, r);
            System.out.println(ret);
        }
    }
}