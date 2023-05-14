import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minstack;
    //初始化堆栈对象。
    public MinStack() {
        stack = new Stack<>();
        minstack = new Stack<>();
    }

    //将元素val推入堆栈。
    public void push(int val) {
        stack.push(val);
        //首先看看小栈是否是空，是空就直接进
        if (minstack.empty()) {
            minstack.push(val);
        }
        //不为空就比较，如果比栈顶元素小就放进去
        else {
            if (val <= minstack.peek()) {
                minstack.push(val);
            }
        }
    }

    //删除堆栈顶部的元素
    public void pop() {
        if (stack.empty()) {
            return;
        }
        //因为是再stack里面找最小值的，如果stack的栈顶就是最小值，被删除了，所以minstack里面的也得删除
        if (stack.peek() == minstack.peek()) {
            stack.pop();
            minstack.pop();
        }
        else {
            stack.pop();
        }
    }

    //获取堆栈顶部的元素。
    public int top() {
        return stack.peek();
    }

    //获取堆栈中的最小元素。
    public int getMin() {
        if (!minstack.empty()) {
            return minstack.peek();
        }
        return -1;
    }
}