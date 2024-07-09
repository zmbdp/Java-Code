package zhiJieChaRuPaiXu;

public class Sort {
    public static void insertSort(int[] arrays) {
        if (arrays.length == 0) {
            System.out.println("真的一滴都没有啦!!!");
            return;
        }
        for (int i = 0; i < arrays.length; i++) {
            int tmp = arrays[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arrays[j] > tmp) {
                    arrays[j + 1] = arrays[j];
                }
                // 找到位置直接退出；
                else {
                    break;
                }
            }
            arrays[j + 1] = tmp;
        }

    }
}
