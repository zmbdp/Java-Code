package gui_bing_pai_xu;

public class MergeSort {
    public static void mergeSort(int[] array) {
        //mergeSortFunc(array, 0, array.length - 1);// 递归的写法
        mergeSortNotFunc(array);// 非递归的写法
    }

    /**
     * 非递归归并排序---
     * 思路：
     * 看成一个数组，找到 right、mid 和 left 的关系，然后迭代往后走
     * @param array 数组
     */
    private static void mergeSortNotFunc(int[] array) {
        int gep = 1;
        while (gep < array.length) {
            int i = 0;
            // 相当于是两个两个一次，慢慢往后面走
            while (i < array.length) {
                int left = i;
                // 画图确定mid和right的位置，很好确定
                int mid = ((left + gep) - 1);
                int right = (mid + gep);
                // 判断是否会越界
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                if (right >= array.length) {
                    right = array.length - 1;
                }
                merge(array, left, mid, right);
                i += (gep * 2);
            }
            gep *= 2;
        }
    }

    private static void mergeSortFunc(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        // 先走左边
        mergeSortFunc(array, left, mid);
        // 再走右边
        mergeSortFunc(array, mid + 1, right);
        // 都回来了再排
        merge(array, left, mid, right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;
        int[] tmpArr = new int[right - left + 1];
        int i = 0;// tmpArr数组的下标
        while (s1 <= e1 && s2 <= e2) {
            // 如果第二个数组的s2下标比第一个数组的s1大，就把第一个放进去
            if (array[s1] < array[s2]) {
                tmpArr[i++] = array[s1++];
            } else {
                tmpArr[i++] = array[s2++];
            }
        }
        // 出来之后判断两段都走完没
        while (s1 <= e1) {
            tmpArr[i++] = array[s1++];
        }
        while (s2 <= e2) {
            tmpArr[i++] = array[s2++];
        }
        if (i >= 0) {
            System.arraycopy(tmpArr, 0, array, left, i);
        }
    }
}
