package dui_lian_xi;
import java.util.Arrays;
public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 6, 5, 2, 4, 3};
        TestHeap testHeap = new TestHeap();
        testHeap.PriorityQueue(arr);
        //System.out.println(Arrays.toString(arr));
        testHeap.push(80);
        int ret1 = testHeap.poll();
        int ret2 = testHeap.poll();
        int ret3 = testHeap.poll();
        int ret4 = testHeap.peek();
        int ret5 = testHeap.peek();
        // 堆排升序
        testHeap.heapSort();
    }
}
