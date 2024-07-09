package zhiJieChaRuPaiXu;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //int[] array = new int[1_0000];
        //orderArray(array);
        //testInsertSort(array);
        int[] array = {12, 2, 564, 678, 1234, 4568, 1234, 4, 6};
        Sort.insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
