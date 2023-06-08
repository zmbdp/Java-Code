package Java_zi_dai_dui;
import java.util.*;

class MinComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}
public class TestHeap {
    public int[] smallestK1(int[] arrays, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : arrays) {
            minHeap.offer(x);
        }
        int[] ret = new int[k];
        int i = 0;
        while ((i < k) && (!minHeap.isEmpty())) {
            ret[i++] = minHeap.poll();
        }
        return ret;
    }
    public int[] smallestK(int[] arrays, int k) {
        int[] ret = new int[k];
        if ((k == 0) || (arrays.length == 0)) {
            return ret;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MinComparator());
        for (int i = 0; i < k; i++) {
            maxHeap.offer(arrays[i]);
        }
        for (int i = k; i < arrays.length; i++) {
            int top = maxHeap.peek();
            if (top > arrays[i]) {
                maxHeap.poll();
                maxHeap.offer(arrays[i]);
            }
        }
        int i = 0;
        while ((i < k) && (!maxHeap.isEmpty())) {
            ret[i++] = maxHeap.poll();
        }
        return ret;
    }
    public static void main(String[] args) {
        int[] arrays = {2, 324, 324, 3, 7234, 45, 7, 3, 21, 4, 56, 78, 798};
        TestHeap testHeap = new TestHeap();
        System.out.println(Arrays.toString(testHeap.smallestK(arrays, 5)));
    }
}
