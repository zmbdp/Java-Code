package xiErPaiXu;

public class ShellSort {
    public static void shellSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        int gap = array.length;
        while (gap > 1) {
            gap /= 2;
            shell(array, gap);
        }
    }
    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int tmp = array[i];
            int j = i - gap;
            for (; j >= 0; j -= gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                }
                else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }
}
