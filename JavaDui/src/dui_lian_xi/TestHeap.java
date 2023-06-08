package dui_lian_xi;
import java.util.Arrays;

public class TestHeap {
    private int[] elem;
    private int size;

    public TestHeap() {
        this.elem = new int[10];
        this.size = 0;
    }


    /**
     * 初始化成大根堆
     * @param arrays
     */
    public void PriorityQueue(int[] arrays) {
        if (arrays.length == 0) {
            return;
        }
        for (int i = 0; i < arrays.length; i++) {
            this.elem[i] = arrays[i];
            this.size++;
        }
        for (int parent = ((size - 1 - 1) / 2); parent >= 0; parent--) {
            shiftDown(parent, this.size);
        }
        // 拷贝数组
        //System.arraycopy(this.elem, 0, arrays, 0, arrays.length);
    }

    /**
     * 尾插
     * @param val
     */
    public void push(int val) {
        //检查是否满了？是否需要扩容？
        if (this.size == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        elem[this.size++] = val;
        shiftUp(this.size - 1);
    }

    /**
     * 取堆顶元素
     * @return ret
     */
    public int poll() {
        if (this.size == 0) {
            System.out.println("真的一滴都没有了");
            return -1;
        }
        int ret = this.elem[0];
        this.elem[0] = this.elem[this.size - 1];
        this.elem[--this.size] = 0;
        // 详细调整
        shiftDown(0, this.size);
        return ret;
    }

    /**
     *  取堆顶元素不删除
     * @return
     */
    public int peek() {
        if (this.elem.length == 0) {
            System.out.println("真的一滴都没有了");
            return -1;
        }
        return this.elem[0];
    }

    /**
     * 堆排升序函数
     * 思路：建立大根堆，拿数组第一个元素和最后一个元素交换，确定好最大元素得位置，再end--；
     */
    public void heapSort() {
        if (this.elem.length == 0) {
            return;
        }
        int end = this.size - 1;
        while (end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            shiftDown(0, end);
            end--;
        }
    }
    /**
     * 向下调整函数
     * @param parent
     * @param len
     */
    private void shiftDown(int parent, int len) {
        if ((parent * 2 + 1) >= len) {
            return;
        }
        int child = (parent * 2) + 1;
        while (child < len) {
            if (((child + 1) < len) && (this.elem[child] < this.elem[child + 1])) {
                child++;
            }
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
            }
            parent = child;
            child = (parent * 2) + 1;
        }
    }

    /**
     * 向上调整函数
     * @param parent 父亲下标
     */
    private void shiftUp(int child) {
        if (this.size == 0) {
            System.out.println("真的一滴也没有了");
            return;
        }
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (this.elem[child] > this.elem[parent]) {
                int tmp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = tmp;
            }
            // 如果比他小了直接退出，说明此时就是大根堆
            // 或者把else删了，直接走到最后再出来，时间复杂度是一样的
            else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
}











