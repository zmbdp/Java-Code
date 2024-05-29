package dui_pai;

import kuai_pai.QuickSort;

import java.util.Random;

public class Test {
    public static void testQuickSort(int[] array) {
        long startTime = System.currentTimeMillis();
        HeapSort.heapSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("时间->" + (endTime - startTime));
    }

    public static void orderArray(int[] array) {
        Random ra = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = ra.nextInt(100_0000);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100_0000];// 最大个数就是这个，再大 1 就报错
        orderArray(array);
        testQuickSort(array);
    }
}
