import java.util.Arrays;

class PriorityQueue {
    public int[] elem;
    public int usedSize;

    public PriorityQueue() {
        this.elem = new int[10];
    }

    /**
     * 建堆的时间复杂度：
     *
     * @param array
     */
    public void createHeap(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        int fuQin = (this.usedSize - 1 - 1) / 2;
        for (; fuQin >= 0; fuQin--) {
            shiftDown(fuQin, this.usedSize);
        }
    }


    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        //检查是否满了？是否需要扩容？
        if (this.usedSize == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        this.elem[this.usedSize] = val;
        this.usedSize++;
        //再向上调整
        shiftUp(usedSize - 1);

    }

    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public int pollHeap() {
        if (this.elem.length == 0) {
            System.out.println("真的一滴都没有了");
            return -1;
        }
        int ret = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[--this.usedSize] = 0;
        // 详细调整
        shiftDown(0, this.usedSize);
        return ret;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        if (this.elem.length == 0) {
            System.out.println("真的一滴都没有了");
            return -1;
        }
        return this.elem[0];
    }

    /**
     *
     * 向下调整的时间复杂度：O(logn)
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     */
    private void shiftDown(int root, int len) {
        int erZi = ((root * 2) + 1);
        while (erZi < len) {
            if (((erZi + 1) < len) && (this.elem[erZi] < this.elem[erZi + 1])) {
                erZi++;
            }
            if (this.elem[erZi] > this.elem[root]) {
                int tmp = this.elem[erZi];
                this.elem[erZi] = this.elem[root];
                this.elem[root] = tmp;
            }
            root = erZi;
            erZi = (root * 2 + 1);
        }
    }

    private void shiftUp(int erZi) {
        int fuQin = (erZi - 1) / 2;
        while (erZi > 0) {
            if (this.elem[erZi] > this.elem[fuQin]) {
                int tmp = this.elem[erZi];
                this.elem[erZi] = this.elem[fuQin];
                this.elem[fuQin] = tmp;
            }
            // 如果比他小了直接退出，说明此时就是大根堆
            // 或者把else删了，直接走到最后再出来，时间复杂度是一样的
            else {
                break;
            }
            erZi = fuQin;
            fuQin = (erZi - 1) / 2;
        }
    }
}
public class Test {
    public static void main(String[] args) {

    }
}
