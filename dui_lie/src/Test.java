import javax.xml.transform.Source;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();//队列,可当栈
        Queue<Integer> queue = new LinkedList<>();//单单只是队列
        Stack<Integer> stack = new Stack<>();//栈
        stack.push(1);//栈的输入
        deque.push(1);//站的输入

        queue.offer(1);//队列的输入
        queue.offer(2);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        deque.offer(1);//队列的输入
    }
    public static void main1(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        System.out.println(myQueue.poll());
    }
}
