package kuai_pai;
import java.util.Stack;

public class QuickSort {
    public static void quickSort(int[] array) {
        //interiorSort1(array,0,array.length - 1);// 递归实现
        interiorSort(array,0,array.length - 1);// 非递归实现
    }

    /**
     * 非递归
     * @param array 数组
     * @param start 左边
     * @param end 右边
     */
    private static void interiorSort(int[] array, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        if (end - start < 150) {
            insertSort(array, start, end);
            return;
        }
        // 先三数取中
        int mid = threeNum(array, start, end);
        // 再和第一个交换，让第一个的值尽量是中间的值
        swap(array, mid, start);

        // 这时start就是比较中间的值了
        stack.push(start);
        stack.push(end);
        while (!stack.isEmpty()) {
            // 如果是小于二十个就直接插排
            if (end - start < 150) {
                insertSort(array, start, end);
                //return;//不可以return
            }
            // 不小于一百五十个就好好排
            else {
                // 先三数取中
                mid = threeNum(array, start, end);
                // 再和第一个交换，让第一个的值尽量是中间的值
                swap(array, mid, start);
                // 挖坑法小左大右，并返回比较中间的值的下标
                int pivot = partition(array, start, end);// 返回中间的下标
                // 再观察中间这个下标是不是已经到了边缘或者差一个到边缘了，因为此时
                if (pivot > start + 1) {
                    // 再插入待排序的左边和右边
                    stack.push(start);
                    stack.push(pivot - 1);
                }
                if (pivot < end - 1) {
                    stack.push(pivot + 1);
                    stack.push(end);
                }
            }
            end = stack.pop();
            start = stack.pop();
        }
    }

    /**
     * 递归方法：让start到end的值有序
     * @param array 数组
     * @param start 左边
     * @param end 右边
     */
    private static void interiorSort1(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        // 如果到后面数据比较少了，就用直接插入排序，因为越到后面的数据越趋近于有序，并且数量烧
        if (end - start < 20) {
            insertSort(array, start, end);
            //插完就走，别再递归了
            return;
        }
        // 先三数取中
        int mid = threeNum(array, start, end);
        // 再和第一个交换，让第一个的值尽量是中间的值
        swap(array, mid, start);
        // 调用挖坑法，先找出中间的下标
        int pivot = partition(array, start, end);
        // 再走左边和右边
        interiorSort1(array,start,pivot - 1);
        interiorSort1(array,pivot + 1, end);
    }

    /**
     * hoare法（赫尔法），将数据变得有序
     * @param array 数组
     * @param left 左边
     * @param right 右边
     * @return 中间的下标
     */
    private static int partition1(int[] array, int left, int right) {
        int i = left;
        int top = array[left];
        while (left < right) {
            /*
             * 为什么一定要从右边开始？
             * 因为从右边开始的话，停下来的那个值一定是小于基准的
             * 然后这个值再跟基准做交换，这时左边的值就全是小于基准的了
             * 假设如果从左边开始，一直到最后一个才停下来，但是最后一个恰巧大于基准
             * 但是这时候，left == right了，右边--进不去，这时候交换的话，就出问题了
             */
            while ((left < right) && (array[right] >= top)) {
                right--;
            }
            while ((left < right) && (array[left] <= top)) {
                left++;
            }
            swap(array, left, right);
        }
        swap(array, i, left);
        return left;
    }

    /**
     * 挖坑法，将小于的放左，大于的放右
     * @param array 数组
     * @param left 左边
     * @param right 右边
     * @return 返回中间的下标
     */
    private static int partition(int[] array, int left, int right) {
        int tmp = array[left];
        while (left < right) {
            while ((left < right) && (array[right] >= tmp)) {
                right--;
            }
            array[left] = array[right];
            while ((left < right) && (array[left] <= tmp)) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = tmp;
        return left;
    }

    /**
     * 前后指针法，将数据变得有序
     * @param array 数组
     * @param left 左边
     * @param right 右边
     * @return 返回中间的下标
     */
    private static int partition2(int[] array, int left, int right) {
        int prev = left ;
        int cur = left+1;
        while (cur <= right) {
            if(array[cur] < array[left] && array[++prev] != array[cur]) {
                swap(array, prev, cur);
            }
            cur++;
        }
        swap(array, prev, left);
        return prev;
    }

    /**
     * 三数去中
     * @param array 数组
     * @param left 左边
     * @param right 右边
     * @return 返回中间数字的下标
     */
    public static int threeNum(int[] array, int left, int right) {
        int mid = (left+right) / 2;
        if(array[left] < array[right]) {
            if(array[mid] < array[left]) {
                return left;
            }else if(array[mid] > array[right]) {
                return right;
            }else {
                return mid;
            }
        }else {
            if(array[mid] < array[right]) {
                return right;
            }else if(array[mid] > array[left]) {
                return left;
            }else {
                return mid;
            }
        }
    }

    /**
     * 交换数字
     * @param array 数组
     * @param left 左边
     * @param right 右边
     */
    private static void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    /**
     * 直接插入排序
     * @param array 数组
     * @param left 左边
     * @param right 右边
     */
    private static void insertSort(int[] array, int left, int right) {
        if (array.length == 0) {
            return;
        }
        for (int i = left + 1; i <= right; i++) {
            int tmp = array[i];
            int j = i - 1;
            for (; j >= left; j--) {
                // 找到tmp需要放的位置，把比它大的数据全往后挪；
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                }
                // 找到位置直接退出；
                else {
                    break;
                }
            }
            // 因为j已经--了，所以要把原来j的位置放入tmp；
            array[j + 1] = tmp;
        }
    }
}
