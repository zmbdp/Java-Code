import java.util.Arrays;
import java.util.Scanner;

public class gaoBo_homework {

    //1.求最大值方法的重载
    public static char Max(int a,int b) {
        return a > b ? '一' : '二';
    }
    public static char Max(double a,double b) {
        return a > b ? '一' : '二';
    }
    public static void main1(String[] args) {
        int a;
        int b;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入想比较的两个数->");
        a = sc.nextInt();
        b = sc.nextInt();
        char max = Max(a, b);
        System.out.print("最大的是第" + max + "个");
    }



    //2求和的重载
    public static int Add(int a, int b) {
        return a + b;
    }
    public static double Add(double a, double b, double c) {
        return a + b + c;
    }
    public static void main2(String[] args) {
        //需求：
        //在同一个类中,
        //分别定义求两个整数的方法和
        //三个小数之和的方法
        //并执行代码，求出结果
        double sum = Add(1,5);
        System.out.print(sum);
    }



    //3.1迭代求斐波那契数
    public static void main3_1(String[] args) {
        int n = 0;
        int i = 3;
        Scanner sc = new Scanner(System.in);
        System.out.print("请问你需要求第几个斐波那契数?->");
        n = sc.nextInt();
        int sum = 0;
        int a = 1;
        int b = 1;
        if (n <= 2)
        {
            System.out.print(1);
        }
        else while (i <= n)
        {
            sum = a + b;
            a = b;
            b = sum;
            i++;
        }
        System.out.print(sum);
    }
    //3.2递归求斐波那契数
    public static int fib(int n){
        if (n <= 2){
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    public static void main3_2(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请问你需要求第几个斐波那契数?->");
        n = sc.nextInt();
        int sum = fib(n);
        System.out.println(sum);
    }



    //4求阶乘和
    public static void main4(String[] args) {
        //4.求1！+2！+3！+4！+ ······ +n!的和
        int n = 0;
        int num = 1;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            num *= i;
            sum += num;
        }
        System.out.print(n + "的阶乘的和为" + sum);
    }



    //5求N的阶乘
    public static void main5(String[] args) {
        int n = 0;
        int num = 1;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        System.out.print(n + "的阶乘的为" + num);
    }



    //6使用函数求最大值
    public static int max2(int a, int b) {
        return Math.max(a, b);
    }
    public static int max3(int a, int b, int c) {
        int m1 = max2(a, b);
        return max2(m1, c);
    }
    public static void main6(String[] args) {
        //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
        //要求:在max3这个函数中，调用max2函数，来实现3个数的最大值计算
        int a = 0;
        int b = 0;
        int c = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        int max = max3(a, b, c);
        System.out.print("最大值是->" + max);
    }



    //递归求每位数的和
    public static int Add2(int n){
        int sum = 0;
        if (n == 0){
            return n;
        }
        else {
            sum += Add2(n / 10);
            sum += (n % 10);
            return sum;
        }
    }
    public static void main7(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        int sum = Add2(n);
        System.out.print(sum);
    }



    //递归求和
    public static int Sum(int n) {
        if (n == 0){
            return 0;
        }
        else {
            return n + Sum(n - 1);
        }
    }
    public static void main8(String[] args) {
        //递归求 1 + 2 + 3 + ... + 10
        int n = 3;
        int sum = Sum(n);
        System.out.println(sum);
    }



    //递归求N的阶层
    public static int  fac(int n) {
        if (n == 1){
            return 1;
        }
        else {
            return n * fac(n - 1);
        }
    }
    public static void main9(String[] args) {
        int n = 5;
        int fa = fac(n);
        System.out.println(fa);
    }



    //递归数组赋值
    public static void fuZhi(int arr[],int i, int n) {
        if (i < 100) {
            arr[i] = n;
            i++;
            n++;
            fuZhi(arr,i,n);
        }

    }
    public static void main10(String[] args) {
        //创建的数组，并且赋初始值,1——100
        int arr[] = new int[100];
        fuZhi(arr, 0, 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i] % 10 == 0){
                System.out.println();
            }
        }
    }



    //模仿实现toString,打印数组
    public static String myToString(int arr[]) {
        if (arr == null) {
            return "null";
        }
        if ((arr.length - 1) == -1) {
            return "[]";
        }
        int i = 0;
        String ret = "[";
        for (i = 0; i < arr.length; i++) {
            ret += arr[i];
            if (i < (arr.length - 1)) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }
    public static void main11(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String net = myToString(arr);
        String ret = Arrays.toString(arr);
        System.out.println(net);
        System.out.println(ret);
    }
}

















