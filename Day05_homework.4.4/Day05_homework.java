import java.util.Random;
import java.util.Scanner;


public class Day05_homework {
    //数组
    /*public static void main(String[] args) {
        //需求：
        //请创建一个长度为6的整数数组，并为数组中的元素赋值。
        //遍历数组，打印所有元素，元素之间用空格隔开。
        int arr[] = new int[6];
        Random ra = new Random();
        for (int i = 0; i < 6; i++)
        {
            arr[i] = ra.nextInt(0,100);
            System.out.print(arr[i] + " ");
        }
    }*/



    //求最小值
    /*public static void main(String[] args) {
        //现有一个小数数组{12.9, 53.54, 75.0, 99.1, 3.14}。
        //请编写代码，找出数组中的最小值并打印。
        double arr[] = {12.9, 53.54, 75.0, 99.1, 3.14};
        double min = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
            }
        }
        System.out.println(min);
    }*/



    /*public static void main(String[] args) {
        //创建一个长度为6的整数数组。请编写代码，
        //随机生成六个0（包含）-100（不包含）之间的整数存放到数组中，
        //然后计算出数组中所有元素的和并打印。
        int n = 0;
        int arr[] = new int[6];
        Random ra = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ra.nextInt(100);
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }*/



    /*public static void main(String[] args) {
        int arr[] = new int[5];
        Random ra = new Random();
        System.out.print("数组：{ ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ra.nextInt(10);
            System.out.print(arr[i]);
            if (i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println(" }");
        long n = 0L;
        for (int i = 0; i < arr.length; i++) {
            n = (n * 10) + arr[i];
        }
        System.out.println("表示的整数为：" + n);
    }*/



    /*public static void main(String[] args) {
        Random ra = new Random();
        int arr[] = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ra.nextInt(101);
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        sum /= arr.length;
        System.out.println(sum);
    }*/



    /*public static void main(String[] args) {
        //有一个数组，其中有十个元素从小到大依次排列 {12,14,23,45,66,68,70,77,90,91}。
        //再通过键盘录入一个整数数字。
        //要求：
        //把数字放入数组序列中，生成一个新的数组，并且数组的元素依旧是从小到大排列的。
        int arr[] = {12, 14, 23, 45, 66, 68, 70, 77, 90, 91};
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        int x = sc.nextInt();
        int brr[] = new int[arr.length + 1];
        int q = 0;
        for (int i = 0,j = 0; i < arr.length; i++,j++) {
            if (x < arr[i] && q != 1)
            {
                brr[j] = x;
                j++;
                q++;
            }
            brr[j] = arr[i];
        }
        for (int i = 0; i < brr.length; i++) {
            System.out.print(brr[i] + " ");
        }
    }*/



    //奇左偶右
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int left = 0;
        int right = arr.length - 1;
        while (left < right)
        {
            while (arr[left] % 2 != 0)
            {
                //左边没找到偶数就一直走
                left++;
            }
            //直到左边找到偶数了就出来

            while (arr[right] % 2 == 0)
            {
                //右边没找到奇数就一直走
                right--;
            }
            //直到右边找到奇数了就出来
            
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
            left++;
            right--;
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }





}





