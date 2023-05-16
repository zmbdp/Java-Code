import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;
    private int queueSize;
    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
        queueSize = 0;
    }

    //将元素 x 压入栈顶
    public void push(int x) {
        //如果都是空就压栈q1
        if (qu1.isEmpty() && qu2.isEmpty()) {
            qu1.offer(x);
        }
        //如果q1不是空就压q1
        else if (!qu1.isEmpty()) {
            qu1.offer(x);
        }
        else {
            qu2.offer(x);
        }
        queueSize++;
    }
    //删除栈顶元素
    public int pop() {
        //如果q1是空，q2不是空，就把q2的留一个放进去
        if (qu1.isEmpty() && (!qu2.isEmpty())) {
            for (int i = 0; i < queueSize - 1; i++) {
                qu1.offer(qu2.poll());
            }
            queueSize--;
            return qu2.poll();
        }
        //如果q2是空，就把q1的留一个，其他全部放进去
        else {
            for (int i = 0; i < queueSize - 1; i++) {
                qu2.offer(qu1.poll());
            }
            queueSize--;
            return qu1.poll();
        }
    }
    //返回栈顶元素。
    public int top() {
        //如果q1是空，q2不是空，就把q2的留一个放进去
        if (qu1.isEmpty() && (!qu2.isEmpty())) {
            for (int i = 0; i < queueSize - 1; i++) {
                qu1.offer(qu2.poll());
            }
            int ret = qu2.poll();
            qu1.offer(ret);
            return ret;
        }
        //如果q2是空，就把q1的留一个，其他全部放进去
        else {
            for (int i = 0; i < queueSize - 1; i++) {
                qu2.offer(qu1.poll());
            }
            int ret = qu1.poll();
            qu2.offer(ret);
            return ret;
        }
    }
    //如果栈是空的，返回 true ；否则，返回 false 。
    public boolean empty() {
        if (qu1.isEmpty() && qu2.isEmpty()) {
            return true;
        }
        return false;
    }
}