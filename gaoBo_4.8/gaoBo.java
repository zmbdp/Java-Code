import java.util.Arrays;
import java.util.Scanner;

public class gaoBo {
    //查找数组中的数字，返回下标
    public static int find(int arr[], int n) {
        int zuo = 0;
        int you = (arr.length - 1);
        while (zuo <= you){
            int mid = (zuo + you) >>> 1;
            if (n > arr[mid]){
                zuo = mid + 1;
            }
            else if (n < arr[mid]){
                you = mid - 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 63, 67, 43, 6, 7, 8, 9, 324, 76, 97, 978};
        int n = 0;

        Arrays.sort(arr);//系统的快排
        System.out.println(Arrays.toString(arr));

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        int sub = find(arr, n);
        if (sub >= 0){
            System.out.println(n + "找到了,的下标为->" + sub);
        }
        else {
            System.out.println(n + "没找到");
        }

        sub = Arrays.binarySearch(arr,n);//系统的二分查找
        System.out.println(sub);

        Arrays.fill(arr, 0);//将arr的值全初始化成0
        System.out.println(Arrays.toString(arr));

        Arrays.fill(arr, 2,5,1);//将arr的2下标到5下标初始化成1，包左不包右
        System.out.println(Arrays.toString(arr));
    }



    //求平均值
    public static double avg(int arr[]) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (sum / arr.length);
    }
    public static void main6(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 3241, 4231, 3254, 5764, 6875, 765, 6785, 654, 2341};
        System.out.println(avg(arr));
    }



    //一行代码copy数组
    public static void main5(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int brr[] = Arrays.copyOf(arr, arr.length);//前传原数组，后传需要复制的大小，如果大小多了，就赋值0
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(brr));

        System.arraycopy(arr, 0, brr, 0, arr.length);
        //1.原数组   2.原数组起始拷贝位置   3.拷贝数组   4.拷贝数组的起始位置   5.拷贝多长
        System.out.println(Arrays.toString(brr));

        int crr[] = Arrays.copyOfRange(arr, 2,5);//局部拷贝，拷贝下标[2, 5),包左不包右
        System.out.println(Arrays.toString(crr));

        int drr[] = arr.clone();//拷贝数组所有值(克隆)
        System.out.println(Arrays.toString(drr));
    }



    //打印数组方便形式
    public static void main4(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        String ret = Arrays.toString(arr);
        System.out.println(ret);
    }



    //汉诺塔问题
    public static void hanit(int n, char pos1, char pos2, char pos3) {
        if (n == 1) {
            move(pos1, pos3);
            return;
        }
        hanit(n - 1, pos1, pos3, pos2);
        move(pos1, pos3);
        hanit(n - 1, pos2, pos1, pos3);
    }
    public static void move(char pos1, char pos2) {
        System.out.print(pos1 + "->" + pos2 + " ");
    }
    public static void main3(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入有多少个盘子->");
        n = sc.nextInt();
        hanit(n, 'A', 'B', 'C');
    }



    public static int Add(long n) {
        int sum;
        if (n < 10) {
            return (int) n;
        } else {
            sum = Add((n / 10));//找到最低位
            sum += n % 10;//把每一位返回的值加起来
            return sum;//返回给上面的值，然后又加起来
        }
    }
    public static void main2(String[] args) {
        long n;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = (long) sc.nextDouble();
        int sum = Add(n);
        System.out.print("和为->" + sum);
    }



    public static void print(long n) {
        if (n < 10) {
            System.out.print(n + " ");
        } else {
            print(n / 10);
            System.out.print((n % 10) + " ");
        }
    }
    public static void main1(String[] args) {
        long n;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = (long) sc.nextDouble();
        print(n);
    }
}











