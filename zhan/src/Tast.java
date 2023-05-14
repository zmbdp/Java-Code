import java.util.LinkedList;
import java.util.Stack;

public class Tast {
    public static void main2(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        myStack.push(5);

        try {
            int x = myStack.pop();
            System.out.println(x);
            x = myStack.pop();
            System.out.println(x);
            x = myStack.pop();
            System.out.println(x);
            x = myStack.pop();
            System.out.println(x);
            x = myStack.pop();
            System.out.println(x);
            x = myStack.pop();
            System.out.println(x);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //栈的底层是一个数组
        Stack<Integer> stack = new Stack<>();
        //入栈
        stack.push(1);
        //弹栈  【并且删除了栈顶元素】
        int x = stack.peek();//获得栈顶元素不删除
        while (x-- > 0) {
            //pop删除栈顶元素并获取
            System.out.print(stack.pop() + " ");
        }
        System.out.print(stack.empty());
        //拿双向链表当作栈，因为双向链表里面也有push和pop方法
        System.out.println();
        System.out.println("==================");
        LinkedList<Integer> sTack = new LinkedList<>();
        sTack.push(1);
        sTack.push(2);
        sTack.push(3);
        sTack.push(4);
        sTack.push(5);
        while (!sTack.isEmpty()) {
            System.out.println(sTack.pop());
        }
    }
}
