package SeqList;

import java.util.ArrayList;
import java.util.List;

public class SeqList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello World");//尾插
        System.out.println(list);
        list.add(1,"ss");//随便插
        System.out.println(list);
        boolean ret = list.remove("ss");
        System.out.println(ret);
        System.out.println(list);
    }
}
