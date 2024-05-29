import java.util.Arrays;

public class PriorityQueue {
    private int[] elem;// 建立一个线式堆
    private int usedSize;// 堆里实际的元素
    /* 构造方法 */
    public PriorityQueue() {
        this.elem = new int[10];
        this.usedSize = 0;
    }
    /* 初始化成小根堆 */
    public void createHeap(int[] array) {
        if (array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int parent = ((this.usedSize - 1 - 1) / 2); parent >= 0; parent--) {
            shiftDown(parent, this.usedSize);
        }
    }
    /* 入队列，但还是要保持小根堆 */
    public void push(int val) {
        //检查是否满了？是否需要扩容？
        if (this.usedSize == this.elem.length) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        // 将新元素插入队尾
        elem[this.usedSize++] = val;
        // 再调用向上调整调整成小根堆
        shiftUp(this.usedSize - 1);
    }
    /* 出队列，但仍然要保持小根堆 */
    public int pollHeap() {
        if (this.usedSize == 0) {
            System.out.println("真的一滴都没有了");
            return -1;
        }
        // 交换
        int ret = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[--this.usedSize] = 0;
        // 详细调整
        shiftDown(0, this.usedSize);
        return ret;
    }
    /* 获取堆顶元素但不删除 */
    public int peekHeap() {
        // 判断数组里面是否存在数据
        if (this.usedSize == 0) {
            System.out.println("真的一滴也没有了");
            return -1;
        }
        return this.elem[0];
    }
    /* 将元素向上调整 */
    private void shiftUp(int child) {
        if (this.usedSize == 0) {
            System.out.println("真的一滴也没有了");
            return;
        }
        int parent = (child - 1) / 2;
        // 当孩子节点下标为0时，证明已经调整完毕
        while (child > 0) {
            if (this.elem[parent] > this.elem[child]) {
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
            }
            else {
                // 说明已经调整完毕
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
    /* 将元素向下调整 */
    private void shiftDown(int parent,int end) {
        if (this.usedSize == 0) {
            System.out.println("真的一滴也没有了");
            return;
        }
        int child = ((parent * 2) + 1);
        while (child < end) {
            // 找出最小的那个孩子节点
            if (((child + 1) < end) &&(this.elem[child] > this.elem[child + 1])) {
                child++;
            }
            // 如果父亲节点比孩子节点大，那就交换
            if (this.elem[parent] > this.elem[child]) {
                int tmp = this.elem[parent];
                this.elem[parent] = this.elem[child];
                this.elem[child] = tmp;
            }
            parent = child;
            child = (parent * 2) + 1;
        }
    }
}