class MyCircularQueue {
    private int arr[];
    //定义一个头
    private int front;
    //定义一个尾
    private int read;
    //构造器，设置队列长度为k。
    public MyCircularQueue(int k) {
        arr = new int[k + 1];
    }

    //向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        //判满
        if (isFull()) {
            return false;
        }
        else {
            arr[read] = value;
            read = (read + 1) % arr.length;
            return true;
        }
    }

    //从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        //判空
        if (isEmpty()) {
            return false;
        }
        else {
            front = (front + 1) % arr.length;
            return true;
        }
    }

    //从队首获取元素。如果队列为空，返回-1。
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        else {
            return arr[front];
        }
    }

    // 获取队尾元素。如果队列为空，返回-1。
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (read == 0) {
            return arr[arr.length - 1];
        }
        else {
            return arr[read - 1];
        }
    }

    //检查循环队列是否为空。
    public boolean isEmpty() {
        return read == front;
    }

    //检查循环队列是否已满。
    public boolean isFull() {
        return (read + 1) % arr.length == front;
    }

    //测试
    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
    }
}