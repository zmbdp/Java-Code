import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        String str = "leetcode";
        char[] arrays = str.toCharArray();
        char[] crrays = {' ', ' ', ' ', ' '};
        char ch = crrays[2];
        System.out.println(crrays[1] == ' ');
    }
    public static void main2(String[] args) {
        long start = System.currentTimeMillis();//获取时间戳
        String s = "";
        for(int i = 0; i < 10000; ++i){
            s += i;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        System.out.println(ch.length);
        System.out.println(ch);
        /*===============================================*/

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("");
        for(int i = 0; i < 10000; ++i){
            sbf.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

        /*===============================================*/

        start = System.currentTimeMillis();
        StringBuilder sbd = new StringBuilder();
        for(int i = 0; i < 10000; ++i){
            sbd.append(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }
    public static void main1(String[] args) {
        String s = "Hello";
        s += " World";
        System.out.println(s);
        /* 等价于： */
        StringBuilder stringBuilder = new StringBuilder("Hello");
        stringBuilder.append(" World");
        String crr = stringBuilder.toString();
        System.out.println(crr);
    }
}
