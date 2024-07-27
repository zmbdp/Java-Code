import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试用例的数量

        while (T-- > 0) {
            int n = scanner.nextInt(); // 读取并忽略换行符
            String s = scanner.next(); // 读取字符串 s
            solve(s);
        }

        scanner.close();
    }

    private static void solve(String s) {
        boolean flag = false; // 标记变量，用于检查字符串中的字符类型
        int n = s.length(); // 获取字符串的长度

        for (int i = 0; i < n; i++) {
            char a = s.charAt(i); // 获取当前字符

            if (panDuanShuZi(a)) { // 如果当前字符是数字
                if (flag || (i > 0 && a < s.charAt(i - 1))) {
                    panDuan(false);
                    return;
                }
            } else { // 如果当前字符不是数字
                flag = true;
                if (i != n - 1 && a > s.charAt(i + 1)) {
                    panDuan(false);
                    return;
                }
            }
        }
        panDuan(true);
    }

    private static boolean panDuanShuZi(char a) {
        return a >= '0' && a <= '9';
    }

    private static void panDuan(boolean flag) {
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}