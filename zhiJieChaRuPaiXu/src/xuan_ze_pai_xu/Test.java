package xuan_ze_pai_xu;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {32,324,-1,45,3,34,6,234};
        SelectSort.selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
