import java.lang.reflect.Array;
import java.util.Arrays;

public class MyStack {
    private int[] elme;
    private int usedSize;


    public MyStack() {
        this.elme = new int[3];
    }


    private boolean isFull() {
        return usedSize == elme.length;
    }


    public void push(int val) {
        if (isFull()) {
            elme = Arrays.copyOf(elme,(2 * elme.length));
        }
        elme[usedSize++] = val;
    }


    public int pop() {
        if (usedSize == 0) {
            throw new NullPointerException("当前是空栈!!!");
        }
        elme[(usedSize - 1)] = 0;
        return elme[--usedSize];
    }

    public int peek() {
        return elme[usedSize - 1];
    }
}
