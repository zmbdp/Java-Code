import sun.java2d.pipe.SpanIterator;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private ListNode head;
    private ListNode last;
    private int usedSize;
    static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //入队列
    public void offer(int val) {
        ListNode node = new ListNode(val);
        //如果为空
        if (head == null) {
            head = node;
            last = node;
        }
        //如果不为空
        else {
            last.next = node;
            last = last.next;
        }
        usedSize++;
    }

    //计算有几个数据
    public int getUsedSize() {
        return usedSize;
    }

    //出队列
    public int poll() {
        if (head == null) {
            throw new NullPointerException("队列为空!!!");
        }
        else {
            int ret = head.val;
            head = head.next;
            return ret;
        }
    }

    //返回不删
    public int peek() {
        if (head == null) {
            throw new NullPointerException("队列为空!!!");
        }
        return head.val;
    }












    public static void main1(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //入队列
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        /*==================================================*/
        while (!queue.isEmpty()) {
            System.out.println(queue.peek());//查看队顶
            System.out.println(queue.poll());//出队列
            System.out.println("==================");
        }
    }
}
