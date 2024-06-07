package demo2;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("Hello ");
        list.add("World.");
        /*list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });*/
        // 简写
        list.forEach(s -> System.out.print(s));
        System.out.println();
        /*Map<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });*/
        System.out.println("====================================================");
        System.out.println("图");
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        map.put(4,4);
        map.put(3,2);
        map.put(5,4);
        map.put(2,1);
        map.put(6,5);
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        System.out.println(entrySet);


        System.out.println("====================================================");
        System.out.println("堆");
        /*Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        queue.add("s");
        queue.add("a");
        queue.add("dfs");
        queue.add("aq");
        queue.add("egr");
        System.out.println(queue);
        Map<String, Integer> map1 = new TreeMap<>();
    }
}
