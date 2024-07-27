import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String a = scanner.next();

            Map<Character, Integer> cnt = new HashMap<>();
            for (char c = 'A'; c <= 'G'; ++c) {
                cnt.put(c, 0);
            }

            for (char c : a.toCharArray()) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }

            int add = 0;
            for (char c = 'A'; c <= 'G'; ++c) {
                if (cnt.get(c) < m) {
                    add += (m - cnt.get(c));
                }
            }

            System.out.println(add);
        }

        scanner.close();
    }
}
