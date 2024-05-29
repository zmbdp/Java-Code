package zhi_jie_cha_ru;

import java.util.Arrays;

public class Test {
    public static void testInsertSort(int[] array) {
        //array = Arrays.copyOf(array, array.length); //这样直接插入排序的话就是排copy出来的副本了
        long startTime = System.currentTimeMillis();
        Sort.insertSort(array);
        long endtTime = System.currentTimeMillis();
        System.out.println("时间->" + (endtTime - startTime));
    }

    public static void orderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
    }

    public static void main(String[] args) {
        //int[] array = new int[1_0000];
        //orderArray(array);
        //testInsertSort(array);
        int[] array = {12,2,564,678,1234,4568,1234,4,6,};
        Sort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
