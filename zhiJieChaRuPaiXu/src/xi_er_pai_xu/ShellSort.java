package xi_er_pai_xu;

public class ShellSort {
    /**
     * 希尔排序 ->
     * 时间复杂度：O(n^1.3) /
     * 空间复杂度：O(1)
     *
     * @param arrays
     */
    public static void shellSort(int[] arrays) {
        if (arrays.length == 0) {
            return;
        }
        int gap = arrays.length;
        while (gap > 1) {
            gap /= 2;
            shell(arrays, gap);
        }
    }

    /**
     * 希尔排序
     *
     * @param array
     * @param gap
     */
    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }
}
