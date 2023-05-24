import java.util.LinkedList;
import java.util.Queue;
public class Test {
    public static void main(String[] args) {
        // 创建一个LinkedList作为队列
        Queue<Integer> queue = new LinkedList<>();
        // 入队列
        boolean falg = queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(falg);
        System.out.println("==================");
        int a = queue.poll();
        int b = queue.poll();
        System.out.println(a);
        System.out.println(b);
        System.out.println("==================");
        int c = queue.peek();
        int d = queue.peek();
        System.out.println(c);
        System.out.println(d);
        System.out.println("==================");
        int size = queue.size();
        System.out.println(size);
        System.out.println("==================");
        falg = queue.isEmpty();
        System.out.println(falg);
        // 将队列全部弹出
        while (!queue.isEmpty()) {
            queue.poll();
        }
        falg = queue.isEmpty();
        System.out.println(falg);

    }
}
