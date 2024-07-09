package kuaiSuPaiXu;

import java.util.Stack;

public class QuickSort {
    public static void quickSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        //interiorSort1(array, 0, array.length - 1);// 递归写法
        interiorSort(array, 0, array.length - 1);// 非递归
    }

    private static void interiorSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        // 当数据少于一百五十个时，直接排序
        if (end - start < 50) {
            insertSort(array, start, end);
            return;
        }
        // 先三数取中
        int mid = threeNum(array, start, end);
        // 交换
        swap(array, start, mid);
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        stack.push(end);
        // 栈不是空就可以继续
        while (!stack.isEmpty()) {
            if (end - start < 50) {
                insertSort(array, start, end);
            }
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
            // 先进去的后出来，所以要先让 end 接收
            end = stack.pop();
            start = stack.pop();
        }
    }
    // 指定范围的直接插入
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

    private static void interiorSort1(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        // 先三数取中
        int mid = threeNum(array, start, end);
        // 再和第一个交换，让第一个的值尽量是中间的值
        swap(array, mid, start);
        int midPow = partition(array, start, end);
        // 再走左边和右边
        interiorSort1(array,start,midPow - 1);
        interiorSort1(array,midPow + 1, end);
    }

    private static int partition(int[] array, int left, int right) {
        int top = array[left];
        while (left < right) {
            while ((left < right) && (array[right] >= top)) {
                right--;
            }
            // 走到这里说明 right 小于基准了，丢到前面去
            array[left] = array[right];
            while ((left < right) && (array[left] <= top)) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = top;
        return left;
    }

    // 三数取中
    private static int threeNum(int[] array, int left, int right) {
        int mid = (left + right) / 2;
        if (array[left] < array[right]) {
            // 大小情况： left < mid < right
            if (array[left] < array[mid] && array[mid] < array[right]) {
                return mid;
            }
            // mid < left < right
            else if (array[mid] < array[left]) {
                return left;
            }
            // left < right < mid
            else {
                return right;
            }
        }
        else {
            // mid < right < left
            if (array[mid] < array[right]) {
                return right;
            }
            // right < left < mid
            else if (array[mid] > array[left]) {
                return left;
            }
            // 在中间的情况
            else {
                return mid;
            }
        }
    }

    // 交换代码
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
