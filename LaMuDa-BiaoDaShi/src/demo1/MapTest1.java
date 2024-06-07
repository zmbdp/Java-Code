package demo1;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest1 {
public static void main(String[] args) {
    Map<String, Integer> map = new TreeMap<>();
    map.put("张三", 1);
    map.put("李四", 1);
    map.put("王五", 1);
    map.put("赵六", 1);
    boolean ret1 = map.containsKey("张三");
    boolean ret2 = map.containsKey("贾七");
    boolean ret3 = map.containsKey("王八");
    System.out.println(ret1);
    System.out.println(ret2);
    System.out.println(ret3);
}
}
