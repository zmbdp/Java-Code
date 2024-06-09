import java.util.Arrays;

public class BitSort {
    // 计数排序
    public static void countSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        // 1、确定数字区间
        int maxVal = array[0];
        int minVal = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < minVal) {
                minVal = array[i];
            }
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }
        // 2、再赋值
        int range = maxVal - minVal + 1;
        int[] count = new int[range];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - minVal]++;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                array[j++] = i + minVal;
            }
        }
    }

    // 归并排序---递归
    public static void mergeSort(int[] array) {
        // write code  here
        mergeSortFunc(array, 0, array.length - 1);
        notMergeSort(array);
    }

    // 归并排序---非递归
    public static void notMergeSort(int[] array) {
        // write code  here
        int gep = 1;
        while (gep < array.length) {
            int i = 0;
            while (i < array.length) {
                int left = i;
                int mid = (left + gep - 1);
                int right = (mid + gep);
                if (mid >= array.length) {
                    mid = array.length - 1;
                }
                if (right >= array.length) {
                    right = array.length - 1;
                }
                mySort(array, left, mid, right);
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
        mergeSortFunc(array, left, mid);
        mergeSortFunc(array, mid + 1, right);
        mySort(array, left, right, mid);
    }

    private static void mySort(int[] array, int left, int right, int mid) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = right;
        int[] tmpArr = new int[right - left + 1];
        int i = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (array[s1] < array[s2]) {
                tmpArr[i++] = array[s1++];
            } else {
                tmpArr[i++] = array[s2++];
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {-2,4,1,7,4,9,2,8,3,4,6,7};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }
}
