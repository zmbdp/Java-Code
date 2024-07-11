import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String ought = in.nextLine().toUpperCase();// 应该输入的字符串
        String actual = in.nextLine().toUpperCase();// 实际得到的字符串
        // 将实际输入的放到哈希表中
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < actual.length(); i++) {
            set.add(actual.charAt(i));
        }
        // 在看实际输入的有没有这个，有就不输出，没有就输出和添加
        for (int i = 0; i < ought.length(); i++) {
            if (!set.contains(ought.charAt(i))) {
                System.out.print(ought.charAt(i));
                set.add(ought.charAt(i));
            }
        }
    }
}