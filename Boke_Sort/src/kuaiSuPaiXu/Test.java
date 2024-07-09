package kuaiSuPaiXu;

public class Test {
    public static void testQuickSort(int[] array) {
        long startTime = System.currentTimeMillis();
        QuickSort.quickSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("时间->" + (endTime - startTime));
    }

    public static void orderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[100_0000];
        orderArray(array);
        testQuickSort(array);
    }
    /*public static void main(String[] args) {
        int[] array = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        QuickSort.quickSort(array);
        System.out.println(Arrays.toString(array));
    }*/
}
