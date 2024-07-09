package guiBingPaiXu;

public class MergeSort {
    public static void mergeSort(int[] array) {
        //mergeSortFunc(array, 0, array.length - 1);
        mergeSortFunc(array);
    }
    private static void mergeSortFunc(int[] array) {
        int gap = 1;
        while (gap < array.length) {
            int i = 0;// 走一趟就要重置一次
            while (i < array.length) {
                int left = i;
                int mid = ((left + gap) - 1);
                int right = mid + gap;
                // 判断是否会越界，越界了就拉回来
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                if (right >= array.length) {
                    right = array.length - 1;
                }
                merge(array, left, mid, right);
                // i 也要迭代往后面走
                i += (gap * 2);
            }
            gap *= 2;
        }
    }
    private static void mergeSortFunc(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        // 找出中间的下标
        int mid = (start + end) / 2;
        // 先走左边和右边，走到底再开始排
        mergeSortFunc(array, start, mid);
        mergeSortFunc(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;
        int i = 0;// tmpArr的下标
        // 当s1 > e1; s2 > e2;就退出循环
        int[] tmpArr = new int[right - left + 1];
        while ((s1 <= e1) && (s2 <= e2)) {
            // 找最小的
            if (array[s1] < array[s2]) {
                tmpArr[i++] = array[s1++];
            }
            else {
                tmpArr[i++] = array[s2++];
            }
        }
        // 出来判断一下第一段和第二段是否都走完了
        while (s1 <= e1) {
            tmpArr[i++] = array[s1++];
        }
        while (s2 <= e2) {
            tmpArr[i++] = array[s2++];
        }
        // 然后进行copy
        if (i >= 0) {
            System.arraycopy(tmpArr, 0, array, left, i);
        }
    }
}
