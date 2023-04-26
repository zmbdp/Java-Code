import java.util.Scanner;

public class Main {
    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
     * 短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
     * 字母和数字都属于字母数字字符。
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入->");
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int left = 0;
            int right = (s.length() - 1);
            String r = s.toLowerCase();
            boolean flag = true;
            while (left < right) {
                //判断是不是字母，是字母就出来，不是就left++，right--
                while ((left < right) &&
                        (!((r.charAt(left) >= '0') && (r.charAt(left) <= '9'))) && //数字也是字符，遇到字符就停下来出去判断。不是字符就++或者--
                        (!((r.charAt(left) <= 'z') && (r.charAt(left) >= 'a')))) {
                    left++;
                }
                while ((left < right) &&
                        (!((r.charAt(right) >= '0') && (r.charAt(right) <= '9'))) &&
                        (!((r.charAt(right) <= 'z') && (r.charAt(right) >= 'a')))) {
                    right--;
                }
                char str1 = (r.charAt(left));
                char str2 = (r.charAt(right));
                if (str1 != str2) {
                    flag = false;
                    break;
                }
                left++;
                right--;
            }
            System.out.println(flag);
            System.out.println("请输入->");
        }
    }



    /**
     * 计算字符串最后一个单词的长度，
     * 单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
     * @param args
     */
    public static void main2(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            int pow = str.lastIndexOf(' ');
            String tmp = str.substring(pow+1);
            System.out.println(tmp.length());
        }
    }



    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            char[] crr = str.toCharArray();
            int i = 0;
            boolean flag = true;
            for (i = (crr.length - 1); i > 1; i--) {
                if ((crr[i] != ' ') && (crr[i - 1] == ' ')) {
                    flag = false;
                    break;
                }
            }
            int count = 0;
            if (flag) {
                count++;
            }
            for (; ((i < crr.length) && (crr[i] != ' ')); i++) {
                count++;
            }
            System.out.println(count);
        }
    }
}