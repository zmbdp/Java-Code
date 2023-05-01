package shunxubiao;

import java.util.Arrays;

public class SeqList {
    private int elemSize;
    private int[] elem;
    private static final int space = 10;

    private void printString() {
        System.out.print("SeqList{" + "elem=");
        for (int i = 0; i < this.elemSize; i++) {
            System.out.print(this.elem[i]);
            if (i < this.elemSize - 1) {
                System.out.print(", ");
            }
        }
        System.out.println('}');
    }


    // 初始化顺序表
    public SeqList() {
        this.elem = new int[space];
    }


    // 将顺序表的底层容量设置为initcapacity
    public SeqList(int initcapacity) {
        this.elem = new int[initcapacity];
    }


    //判断是否需要扩容
    private boolean isFull() {
        return this.elemSize >= this.elem.length;
    }


    // 新增元素,默认在数据最后新增
    public void add(int data) {
        if (isFull()) {
            //进来就开始扩容
            this.elem = Arrays.copyOf(this.elem,2 * this.elemSize);
        }
        this.elem[this.elemSize++] = data;
    }


    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        if (isFull()){
            this.elem = Arrays.copyOf(this.elem,2 * this.elemSize);
        }
        for (int i = this.elemSize; i > pos; ) {
            this.elem[i] = this.elem[--i];
        }
        this.elem[pos] = data;
        this.elemSize++;
    }


    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.elemSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }


    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.elemSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }


    // 获取 pos 位置的元素
    public int get(int pos) {
        if (pos < 0 || pos >= this.elemSize) {
            throw new NullPointerException("输入下标不合法!!!");
        }
        return this.elem[pos];
    }


    // 给 pos 位置的元素设为 value
    public void set(int pos, int value) {
        if (pos >= 0 && pos <= this.elemSize) {
            this.elem[pos] = value;
            if (pos == this.elemSize) {
                this.elemSize++;
            }
        }
        else {
            System.out.println("未找到该位置的下标");
        }
    }


    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if (this.elemSize == 0) {
            return;
        }
        int key = 0;
        boolean flag = false;
        int i = 0;
        for (; i < this.elemSize; i++) {
            if (this.elem[i] == toRemove) {
                System.out.println("存在" + toRemove + "下标为" + i);
                flag = true;
                break;
            }
        }
        if (flag) {
            for (; i < this.elemSize - 1; i++) {
                this.elem[i] = this.elem[i + 1];
            }
            this.elem[--this.elemSize] = 0;
        }
        else {
            System.out.println("未找到!!!");
        }
    }


    // 获取顺序表长度
    public int size() {
        return this.elemSize;
    }


    // 清空顺序表
    public void clear() {
        for (int i = 0; i < this.elemSize; i++) {
            this.elem[i] = 0;
        }
        this.elem = null;
    }


    // 打印顺序表，注意：该方法并不是顺序表中的方法，为了方便看测试结果给出的
    public void display() {
        this.printString();
    }
}
