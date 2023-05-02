package SeqList;
import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void fun(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ch1.length; i++) {
            //遍历字符串2，如果遍历完还没有变成false，就放到list里面
            boolean flag = true;
            for (int j = 0; j < ch2.length; j++) {
                if (ch1[i] == ch2[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                //进来了说明是不相等的
                list.add(String.valueOf(ch1[i]));
            }
        }
        StringBuilder ret = new StringBuilder();
        for (String s : list) {
            ret.append(s);
        }
        System.out.println(ret);
    }
    public static void main(String[] args) {
        fun("Hello World","loe");
    }
}
