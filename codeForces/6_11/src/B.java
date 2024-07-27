import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            findMaxSum(sc.nextInt());
        }
    }
    private static void findMaxSum(int n){
        if (n <= 3) {
            System.out.println(n);
            return;
        }
        int cur = n;
        if (cur % 2 != 0) {
            cur++;
        }
        while (cur >= 2) {
            if (cur / 2 < 2) {
                System.out.println(cur);
                return;
            }
            cur /= 2;
        }
    }
}
