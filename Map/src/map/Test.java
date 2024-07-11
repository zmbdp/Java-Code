package map;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        char[] ch1 = {'h', 'e', 'l', 'l', 'o'};
        String ch2 = new String(ch1);
        System.out.println(ch1 == ch2.toCharArray());
    }
    public static void main3(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(-12312, 423);
        System.out.println(map.get(-12312));
        System.out.println(map.get(-1231));
    }
    public static void main2(String[] args) {
        SortedSet<String> set1 = new TreeSet<>();
        Set<String> set = new TreeSet<>();
        // 格式是：set.add(key);
        set.add("hello");
        set.add("world");
        set.add("bit");
        Iterator<String> it = set.iterator();// 只有 it 里面才有迭代器
        /*while (it.hasNext()) {
            System.out.println(it.next());
        }*/
        System.out.println(set.contains("hello"));
        System.out.println(set.contains("hel"));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5,1);
        map.put(23,1);
        map.put(1,1);
        map.put(4,1);
        System.out.println("sdafs");
        Set<Character> set2 = new HashSet<>();
    }
    public static void main1(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        // 格式是 map.put(key, val);
        map.put("Hello", 3);// 底层是二叉搜索树，比较 key
        map.put("World", 2);
        map.put("Map", 18);
        map.put("Set", 13);
        map.put("IDEA", 124);
        map.put("Abed", 14);
        System.out.println(map.get("Hello"));
        System.out.println(map.get("World"));// 没有返回的是空
        System.out.println(map.getOrDefault("MapSet", 96453));// 没有就会返回默认的这个值
        System.out.println(map.getOrDefault("Map", 96453));// 有的话就返回那个本来的值
        System.out.println("==================");
        System.out.println(map.getOrDefault("Hello", 96453));
        System.out.println(map.remove("Hello"));// 删除此节点，删除完成之后回返回此节点的 val
        System.out.println(map.getOrDefault("Hello", 96453));
        System.out.println(map.remove("Hello"));
        Set<String> set = map.keySet();// 拿到所有的 key，并且按照从小到大的顺序排列
        Collection<Integer> collection = map.values();// 拿到所有的 val 但是不排序，最后进去的最先出来
        map.put("Abed", 14);
        System.out.println(map.get("Abcd"));
        map.put("Abed", 1);// 如果找到了相同的 key，只会更新一下它所对应的 val。
        System.out.println(map.get("Abed"));
        for (Map.Entry<String, Integer> entry : map.entrySet()) {// 将所有的 key 和所对应的 val 保存起来
            System.out.println(entry);
        }
    }
}
