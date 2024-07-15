package ha.xi.biao;

import java.util.Map;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
        HashBuck<String, String> hashBuck = new HashBuck<>();
        hashBuck.put("24", "2");
        hashBuck.put("24", "2");
        hashBuck.put("25", "2");
        hashBuck.put("11", "2");
        hashBuck.put("-10", "2");
        hashBuck.put("35", "2");
        hashBuck.put("33", "2");
        hashBuck.put("125", "2");
        hashBuck.put("2678", "2");
        hashBuck.put("-2314", "2");
        hashBuck.put("28", "2");
        hashBuck.put("-34", "2");
        hashBuck.put("39", "32");
        hashBuck.put("27", "2");
        hashBuck.put("qq", "123");
        hashBuck.put("qw", "123");
        hashBuck.put("qq", "123");
        String str1 = "123";
        String str2 = "123";
        hashBuck.put(str1, "付豪");
        System.out.println(hashBuck.getValue(str2));
        System.out.println(hashBuck.getValue("28"));
        System.out.println(hashBuck.getValue("66"));
        System.out.println(hashBuck.getValue("28", "9999"));
        System.out.println(hashBuck.getValue("66", "9999"));
        System.out.println("Hello World");
    }
}
