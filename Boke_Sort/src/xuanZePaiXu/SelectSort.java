package xuanZePaiXu;

public class SelectSort {
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int tmpPow = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[tmpPow]) {
                    tmpPow = j;
                }
            }
            int tmp = array[i];
            array[i] = array[tmpPow];
            array[tmpPow] = tmp;
        }
    }
}
