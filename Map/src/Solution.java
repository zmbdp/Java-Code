import java.util.*;

public class Solution {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        // 1、先放进去
        for (String s : words) {
            if (map.get(s) == null) {
                // 没有
                map.put(s, 1);
            }
            else {
                // 有了
                map.put(s, (map.get(s) + 1));
            }
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int ret = o1.getValue().compareTo(o2.getValue());
                if (ret == 0) {
                    ret = o2.getKey().compareTo(o1.getKey());
                }
                return ret;
            }
        });
        // 2、遍历map，将map的所有元素插入到堆中
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // 如果没插满
            if (priorityQueue.size() < k) {
                priorityQueue.offer(entry);
            }
            // 如果插满了
            else {
                assert priorityQueue.peek() != null;
                if (priorityQueue.peek().getValue().compareTo(entry.getValue()) < 0) {
                    priorityQueue.poll();
                    priorityQueue.offer(entry);
                }
                else if (priorityQueue.peek().getValue().compareTo(entry.getValue()) == 0) {
                    if (priorityQueue.peek().getKey().compareTo(entry.getKey()) > 0) {
                        // 说明表中的元素比这个元素大，在这个后面，所以换掉
                        priorityQueue.poll();
                        priorityQueue.offer(entry);
                    }
                }
            }
        }
        // 3、将堆中的所有元素放到链表中，要逆置链表
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ret.add(Objects.requireNonNull(priorityQueue.poll()).getKey());
        }
        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        String[] srt = {"i","love","leetcode","i","love","coding"};
        List<String> ret = topKFrequent(srt, 3);
        System.out.println(ret);
    }
}