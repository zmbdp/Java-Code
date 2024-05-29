package zhi_jie_cha_ru;

public class Sort {
    public static void insertSort(int[] arrays) {
        if (arrays.length == 0) {
            return;
        }
        for (int i = 0; i < arrays.length; i++) {
            int tmp = arrays[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 找到tmp需要放的位置，把比它大的数据全往后挪；
                if (arrays[j] > tmp) {
                    arrays[j + 1] = arrays[j];
                }
                // 找到位置直接退出；
                else {
                    break;
                }
            }
            // 因为j已经--了，所以要把原来j的位置放入tmp；
            arrays[j + 1] = tmp;
        }
    }
}