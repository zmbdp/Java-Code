package dui_pai;

public class HeapSort {
    public static void heapSort(int[] array) {
        createBigHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            swap(array, end, 0);
            siftDown(array, 0, end);
            end--;
        }
    }

    private static void createBigHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            siftDown(array, i, array.length);
        }
    }

    private static void siftDown(int[] array, int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child] < array[child + 1]) {
                child++;
            }
            if (array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
