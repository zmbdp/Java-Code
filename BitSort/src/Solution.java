import java.util.Arrays;

class Solution {
    public static int[] sortArray(int[] nums) {
        notMergeSort(nums);
        return nums;
    }

    private static void notMergeSort(int[] array) {
        // write code  here
        int gep = 1;
        while (gep < array.length) {
            int i = 0;
            while (i < array.length) {
                int left = i;
                int mid = ((left + gep) - 1);
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

    private static void mySort(int[] array, int left, int mid, int right) {
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

    public static void main(String[] args) {
        int[] array = {342, 2345, 345, 3456, 1234, 34, 345, 456, 4567, 1234};
        array = sortArray(array);
        System.out.println(Arrays.toString(array));
    }
}