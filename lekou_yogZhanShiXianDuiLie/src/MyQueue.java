import java.time.chrono.IsoChronology;
import java.util.Stack;

class MyQueue {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    private int stackSize;
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
        stackSize = 0;
    }
    //将元素 x 推到队列的末尾
    public void push(int x) {
        //放到入栈的栈里面
        pushStack.push(x);
        stackSize++;
    }
    //从队列的开头移除并返回元素
    public int pop() {
        //从出栈的栈一个一个放到入栈的栈
        for (int i = 0; i < stackSize - 1; i++) {
            //从pushStack拿出元素放到popStack
            popStack.push(pushStack.pop());
        }
        int ret = pushStack.pop();
        //pop完之后也要把popStack里面的元素放到pushStack里面
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        stackSize--;
        return ret;
    }
    //返回队列开头的元素
    public int peek() {
        //先拿到第一个插入的元素，最后返回
        int ret = pop();
        //因为上面stackSize--了，但是元素个数没变，这里要加回来
        stackSize++;
        //拿到这个元素之后，现在元素全在pushStack中，但是ret是第一个，所以要把pushStack的元素全部倒出来，先放ret进去
        while (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        pushStack.push(ret);
        //弄完之后重新把popStack的元素放到pushStack里面
        while (!popStack.isEmpty()) {
            pushStack.push(popStack.pop());
        }
        return ret;
    }
    // 如果队列为空，返回 true ；否则，返回 false
    public boolean empty() {
        return pushStack.isEmpty();
    }
}