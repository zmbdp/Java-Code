import java.util.Random;
import java.util.Scanner;

public class Day05 {
    //逢7过
    /*public static void main(String[] args) {
        //朋友聚会的时候可能会玩一个游戏:逢7过
        //游戏规则:
        //从任意一个数字开始报数，当你要报的数字是包含7或者是7的倍数时，都要说过:过
        //需求:使用程序在控制台打印出1-100之间的满足逢七必过规则的数据
        for (int i = 1; i <= 100; i++)
        {
            if (i % 7 == 0 || i % 10 == 7 || (i / 10) % 10 == 7)
            {
                System.out.println("过");
                continue;
            }
            System.out.println(i);
        }
    }*/


    //求平方根
    /*public static void main(String[] args) {
        //需求:
        //键盘录入一个大于等于2的整数X，
        //计算并返回X的平方根结果只保留整数部分，
        //小数部分将被舍去
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数->");
        n = sc.nextInt();
        int i = 0;
        while(true)
        {
            if((i + 1) * (i + 1) > n)
            {
                break;
            }
            i++;
        }
        System.out.println(i);
    }*/


    //求质数
    /*public static void main(String[] args) {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入->");
        x = sc.nextInt();
        int i = 0;
        for (i = 2; i <= (x / 2); i++)
        {
            if (x % i == 0)
            {
                break;
            }
        }
        if (((x / 2) + 1) == i)
        {
            System.out.println("是质数");
        }
        else
        {
            System.out.println("不是质数");
        }
    }*/


    //优化版：
    /*public static void main(String[] args) {
        int x = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入->");
        x = sc.nextInt();
        int pow = 0;
        int n = 0;
        //求出平方根
        while(true)
        {
            if((pow + 1) * (pow + 1) > x)
            {
                break;
            }
            pow++;
        }


        for (n = 2; n <= pow + 1; n++)
        {
            if (x % n == 0)
            {
                break;
            }
        }
        if ((pow + 2) == n)
        {
            System.out.println( x + "是质数");
        }
        else
        {
            System.out.println(x + "不是质数");
        }
    }*/


    //猜数字游戏：
    /*public static void main(String[] args) {
        //需求：
        //生成一个随机数，猜这个数字
        int number = 0;//生成的随机数
        Random ra = new Random();
        number = ra.nextInt(-100,100);
        int choose = 0;//选择玩不玩
        Scanner sc = new Scanner(System.in);
        System.out.println("请问你想玩游戏吗?(1.开始/0.退出)->");
        choose = sc.nextInt();
        if (choose != 0)
        {
            do {
                if ((choose > 1) || (choose < 0))
                {
                    while ((choose > 1) || (choose < 0))
                    {
                        System.out.println("输入错误，请重新输入->");
                        choose = sc.nextInt();
                    }
                }
                int n = 0;//猜的数字
                System.out.println("请输入你猜的数字");
                n = sc.nextInt();
                if (n == number)
                {
                    System.out.println("猜对了!!!");
                    System.out.println("请问要继续吗?(1.继续/0.退出)->");
                    choose = sc.nextInt();
                    if (choose == 1)
                    {
                        number = ra.nextInt(0,10);
                    }
                }
                else
                {
                    if (n > number)
                    {
                        System.out.println("猜大了");
                    }
                    else
                    {
                        System.out.println("猜小了");
                    }
                }
            }while (choose != 0);
        }
        if (choose == 0)
        {
            System.out.println("退出成功!!!");
        }
    }*/



    //数组的初始化
    /*public static void main(String[] args) {
        int arr[] = new int[100];//数组的初始化(不存入数据的初始化)
        int brr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};//初始化，不过一定要填数据
        int sz = arr.length;
        for (int i = 0; i < 100; i++)
        {
            System.out.println(arr[i] + "," + i);
        }
        System.out.println(sz);
    }*/



    //统计个数
    /*public static void main(String[] args) {
        //需求：
        //定义一个数组，
        //存储1,2,3,4,5,6,7,8,9,10遍历数组得到每一个元素，
        //统计数组里面一共有多少个能被3整除的数字
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 3 == 0)
            {
                System.out.println(arr[i]);
                count++;
            }
        }
        System.out.println("一共有" + count + "个能被3整除");
    }*/



    //变化数据
    /*public static void main(String[] args) {
        //定义一个数组，存储1,2,3,4,5,6,7,8,9,10遍历数组得到每一个元素要求:
        //1.如果是奇数，则将当前数字扩大两倍
        //2.如果是偶数，则将当前数字变成二分之一
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < arr.length; i++) {
            //偶数
            if (arr[i] % 2 == 0)
            {
                arr[i] /= 2;
            }
            else
            {
                arr[i] *= 2;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }*/



    //求大最值
    /*public static void main(String[] args) {
        //需求:
        //已知数组元素为{33, 5, 22, 44, 55}
        //请找出数组中最大值并打印在控制台
        int arr[] = {33, 5, 22, 44, 55};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        System.out.println("最大值为" + max);
    }*/



    //求最小值
    /*public static void main(String[] args) {
        //需求:
        //已知数组元素为{33, 5, 22, 44, 55}
        //请找出数组中最大值并打印在控制台
        int arr[] = {33, 5, 22, 44, 55};
        int min = arr[0];
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < min)
            {
                min = arr[i];
            }
        }
        System.out.println("最小值为" + min);
    }*/



    //遍历数组求和
    /*public static void main(String[] args) {
        //需求:
        //生成10个1~100之间的随机数存入数组。
        //1.求出所有数据的和
        //2.求所有数据的平均数
        //3.统计有多少个数据比平均值小
        double sum = 0;//和
        int arr[] = new int[10];
        Random ra = new Random();
        //赋值
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = ra.nextInt(1,100);
        }
        //求和
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        //求平均值
        double median = (sum / arr.length);//平均数
        //统计有多少个小于平均值
        int count = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < median)
            {
                count++;
            }
        }
        System.out.println("所有数据的和为->" + sum);
        System.out.println("所有数据的平均值为->" + median);
        System.out.println("比平均值小的数字有" + count + "个");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }*/



    //交换数组中的数据
    /*public static void main(String[] args) {
        //需求:
        //定义一个数组，存入1,2,3,4,5。
        //按照要求交换索引对应的元素
        //交换前:1,2,3,4,5
        //交换后:5,2,3,4,1
        int arr[] = {1, 2, 3, 4, 5, 6};
        int leng = arr.length;
        for (int i = 0; i < (arr.length / 2); i++)
        {
            arr[i] = arr[i] ^ arr[--leng];
            arr[leng] = arr[i] ^ arr[leng];
            arr[i] = arr[leng] ^ arr[i];
        }
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }*/



    //打乱数组中的数据
    /*public static void main(String[] args) {
        //需求:
        //定义一个数组，存入1~5。
        //要求打乱数组中所有数据的顺序
        int i = 0;
        int arr[] = {1, 2, 3, 4, 5};
        int x = 0;
        for (i = 0; i < 5; )
        {
            Random ra = new Random();
            x = ra.nextInt(0,arr.length - 1);
            if (x != i)
            {
                arr[i] = arr[i] ^ arr[x];
                arr[x] = arr[i] ^ arr[x];
                arr[i] = arr[x] ^ arr[i];
                i++;
            }
        }
        for (i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }*/

    //另一种方案：
    public static void main(String[] args) {
        //需求:
        //定义一个数组，存入1~5。
        //要求打乱数组中所有数据的顺序
        int i = 0;//可当作arr数组的下标
        int arr[] = new int[5];
        int x = 0;//随机生成的数
        for (i = 0; i < arr.length; )
        {
            Random ra = new Random();
            x = ra.nextInt(1,arr.length + 1);//这个库函数包左不包右，包头不包尾
            int j = 0;
            //判断一下数组里面是否有和x相等的数字，如果有，就跳过
            for (j = 0; j < i; j++)
            {
                if (arr[j] == x)
                {
                    break;
                }
            }
            //如果i == j的，那就证明遍历完了一遍数组，没发现和x相等的量，就可以赋值了
            if (i == j)
            {
                arr[i] = x;
                i++;
            }
        }
        for (i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }

        //将arr的地址给brr，使brr指向arr
        int brr[] = arr;
        System.out.println("\n");
        for (int k = 0; k < brr.length; k++) {
            System.out.print(brr[k] + " ");
        }
    }
}
























