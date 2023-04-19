import javax.xml.bind.annotation.XmlTransient;
import java.util.*;

public class gaoBo_homework {
    //奇数位于偶数之前
    public static void parity(int arr[]) {
        int left = 0;
        int right = (arr.length - 1);
        while (left < right) {
            //先找到前面的偶数
            while ((left < right) && (arr[left] % 2) != 0) {
                //前面的是奇数就走
                left++;
            }
            //出来表示找到偶数了

            //在找到后面的奇数
            while ((left < right) && (arr[right] % 2) == 0) {
                //是偶数就走
                right--;
            }
            //找到奇数了
            if (left != right){
                arr[left] = arr[right] ^ arr[left];
                arr[right] = arr[left] ^ arr[right];
                arr[left] = arr[right] ^ arr[left];
            }
        }
    }
    public static void main7(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        parity(arr);
        System.out.println(Arrays.toString(arr));
    }



    //二分查找
    public static int binarySearch(int arr[], int n) {
        int left = 0;//左下标
        int right = (arr.length - 1);//右下标
        int mid = 0;
        while (left < right) {
            mid = ((left + right) / 2);
            if (n > arr[mid]) {
                left = mid + 1;
            }
            else if (n < arr[mid]) {
                right = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -(mid + 1);
    }
    public static void main6(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        System.out.println(n + "的下标为->" + binarySearch(arr, n));

    }



    //冒泡排序
    public static void Qrow(int arr[]) {
        int q = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flage = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j + 1] ^ arr[j];
                    flage = true;
                }
            }
            if (flage == false) {
                return;
            }
        }
    }
    public static void main5(String[] args) {
        int arr[] = {2134,234,2534,4635,8765,867,3421,3};
        Qrow(arr);
        System.out.println(Arrays.toString(arr));
    }



    //两数之和
    public static int[] twoSum(int arr[], int target) {
        int brr[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (Arrays.binarySearch(arr, (target - arr[i])) >=0) {
                    brr[0] = i;
                    brr[1] = Arrays.binarySearch(arr, (target - arr[i]));
                    break;
            }
        }
        return brr;
    }
    public static void main4(String[] args) {
        //给定一个整数数组nums和一个整数目标值target，
        //请你在该数组中找出和为目标值target的那两个整数
        //并返回它们的数组下标。
        int nums[] = {11, 7, 2, 15};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int target = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        target = sc.nextInt();
        int arr[] = twoSum(nums, target);
        System.out.println(Arrays.toString(arr));
    }



    //只出现一次的数字
    public static int singular(int arr[]) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if ((i <= arr.length - 2) && (arr[i] == arr[i + 1])) {
                i++;
            }
            else {
                return arr[i];
            }
        }
        return -(arr.length + 1);
    }
    public static void main3(String[] args) {
        int arr[] = {4, 1, 2, 1, 2, 4, 3};
        int num = singular(arr);
        System.out.println(num);
    }



    //多数元素
    /*public static int find(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[i] == arr[j])) {
                    count++;
                }
                if (count > (arr.length / 2)) {
                    return arr[i];
                }
            }
        }
        return -1;
    }*/
    //优化版：
    /*public static int find(int arr[]) {
        Arrays.sort(arr);
        return (arr[arr.length / 2]);
    }*/
    //进阶版：
    public static int find(int arr[]) {
        int ret = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (ret == arr[i]) {//打阵地战，同一个阵地的++
                count++;
            }
            else {//不同阵地的--，然后一定会多有那么几个，走完了就出去，多的就是ret
                count--;
            }
            if (count == 0) {
                ret = arr[i + 1];
            }
        }
        return ret;
    }
    public static void main2(String[] args) {
        //给定一个大小为n的数组,找到其中的多数元素。
        //多数元素是指在数组中出现次数大于[n/2]的元素。
        int arr[] = {2, 1, 1, 2, 1, 1, 2};
        int num = find(arr);
        System.out.println(num);
    }



    //存在连续三个奇数的数组
    public static boolean threeConsecutiveOddNumbers(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if ((i <= arr.length - 3) && (arr[i] % 2 != 0) && (arr[i + 1] % 2 != 0) && (arr[i + 2] % 2 != 0)) {
                return true;
            }
        }
        return false;
    }
    public static void main1(String[] args) {
        int arr[] = new int[10];
        Random ra = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ra.nextInt(101);
        }
        System.out.println(Arrays.toString(arr));
        boolean flage = threeConsecutiveOddNumbers(arr);
        System.out.println(flage);
    }
}














