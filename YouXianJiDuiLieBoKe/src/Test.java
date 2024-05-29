public class Test {
    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        int[] array = {3, 2, 7, 543, 1, 0, 453};
        priorityQueue.createHeap(array);
        // push
        priorityQueue.push(4);
        priorityQueue.push(-1);
        System.out.println("========peekHeap========");
        System.out.println(priorityQueue.peekHeap());
        System.out.println("========pollHeap========");
        System.out.println(priorityQueue.pollHeap());
        System.out.println(priorityQueue.pollHeap());
        System.out.println(priorityQueue.pollHeap());
    }
}
