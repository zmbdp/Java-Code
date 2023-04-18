import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

public class Day06 {
    //自定义函数
    /*public static void main(String[] args) {
        printGirlFriend();
    }
    public static void printGirlFriend(){
        System.out.println("姓名：" + "YangFei");
        System.out.println("年龄：" + "19");
        System.out.println("性别：" + "girl");
        System.out.println("身高：" + 1.68);
        System.out.println("体重(kg)：" + 47);
    }*/




    //加法函数
    /*public static int jia(int x, int y)
    {
        return (x + y);
    }
    //减法函数
    public static int jian(int x, int y)
    {
        return (x - y);
    }
    //乘法函数
    public static int cheng(int x, int y)
    {
        return (x * y);
    }
    //除法函数
    public static double chu(double x, double y)
    {
        return (x / y);
    }

    //菜单函数
    public static void caiDan()
    {
        System.out.println("*****************************************");
        System.out.println("******* 1、加法             2、减法*******");
        System.out.println("******* 3、乘法             4、除法*******");
        System.out.println("*************    0、退出    **************");
        System.out.println("*****************************************");
    }

    public static double Test()
    {
        int choose = 0;//选择计算器
        Scanner sc = new Scanner(System.in);
        System.out.print("请选择->");
        choose = sc.nextInt();
        //如果为0，就直接返回
        if (choose == 0)
        {
            System.out.println("退出成功!!!");
            return 0;
        }
        int a = 0;
        int b = 0;
        double sum = 0;
        while (choose != 0)
        {
            if ((choose >= 0) && (choose <= 4))
            {
                System.out.println("请输入两个数字");
                a = sc.nextInt();
                b = sc.nextInt();
            }
            switch (choose)
            {
                case 0:
                    System.out.println("退出成功!!!");
                    choose = 0;
                    break;
                case 1:
                    sum = jia(a,b);
                    choose = 0;
                    break;
                case 2:
                    sum = jian(a,b);
                    choose = 0;
                    break;
                case 3:
                    sum = cheng(a,b);
                    choose = 0;
                    break;
                case 4:
                    sum = chu((double)a,(double)b);
                    choose = 0;
                    break;
                default:
                    System.out.println("选择错误，请重试!!!");
                    System.out.print("请选择->");
                    choose = sc.nextInt();
                    if (choose == 0)
                    {
                        System.out.println("退出成功!!!");
                    }
                    break;
            }
        }
        return sum;
    }

    //main函数
    public static void main(String[] args) {
        caiDan();
        double num = Test();
        System.out.println(num);
    }*/



    //比较函数
    /*public static int compare(int a, int b)
    {
        return Math.max(a, b);
    }

    //计算函数
    public static int getArea(int leng, int width)
    {
        return (leng * width);
    }
    
    public static void main(String[] args) {
        int x = 0;
        int y = 0;

        System.out.print("请输入第一个长方形的长和宽:");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        int area1 = getArea(x, y);

        System.out.print("请输入第二个长方形的长和宽:");
        x = sc.nextInt();
        y = sc.nextInt();
        int area2 = getArea(x, y);

        //给比较函数比较
        int max = compare(area1,area2);

        System.out.println("最大面积为:" + max);
    }*/


    /*public static void print(int i)
    {
        i++;
        System.out.println("hehe");
        if (i < 100)
        {
            print(i);
        }
    }


    public static void main(String[] args) {
        int i = 0;
        print(i);
    }*/



    /*public static boolean findNum(int[] arr, int num)
    {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
            {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入需要查询的数字->");
        num = sc.nextInt();
        boolean choose = findNum(arr,num);
        System.out.println(choose);
    }*/



    //复制数组
    /*public static void main(String[] args) {
        //需求:定义一个方法copyOfRange(int[]arr,int from,int to)
        //功能:将数组arr中从索引from (包含from)开始
        //到索引to结束(包含to)的元素复制到新数组中
        //将新数组返回
        int arr[] = {1, 2, 3, 4, 123, 4123, 234, 543, 35, 4, 7, 567, 6785, 5342};
        int to = 0;
        int from = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请问从第几个开始?->");
        from = sc.nextInt();
        System.out.print("请问从第几个结束?->");
        to = sc.nextInt();
        int brr[] = copyOfRange(arr,from - 1,to);
        System.out.print("{");
        for (int i = 0; i < brr.length; i++) {
            System.out.print(brr[i]);
            if (i < brr.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }


    public static int[] copyOfRange(int arr[],int from,int to) {
        int brr[] = new int[to - from];
        int j = 0;
        for (int i = from; i < to; i++,j++) {
            brr[j] = arr[i];
        }
        return brr;
    }*/


    /*public static void main(String[] args) {
        int j = 0;//奇数和
        int o = 0;//偶数和
        int i = 0;
        int sum = 0;//总和
        for (i = 1; i <= 100; i++)
        {
            if (i % 2 == 1)
            {
                j += i;
            }
            else
            {
                o += i;
            }
            sum += i;
        }
        System.out.println(j + "," + o + "," + sum);
    }*/



    /*public static void main(String[] args) {
        int num = 1;
        int i = 1;
        int j = 1;
        int sum = 0;

        *//*for (i = 0; i < 5; i++) {
            num = 1;
            for (j = 1; j <= 5 - i; j++) {
                num *= j;
            }
            sum += num;
        }*//*

        //优化版
        for (i = 1; i <= 5; i++) {
            num *= i;
            sum += num;
        }

        String arr[] = {"sdhahlakhdlf"};
        System.out.printf("%d\n", num);
        System.out.printf("%d", sum);
        System.out.printf("\n%S", arr);
    }*/



    /*public static void main(String[] args) {
        int age = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入你的姓名:");
        //String q = sc.nextLine();//因为回车给他算了，所以这个用来放回车的，防止把name覆盖了
        String name = sc.nextLine();//读取一行的数据  -------->  最优把字符串放到最上面
        //String name = sc.next();//读取到空格的数据：付 豪 -> 输出：付

        System.out.print("请输入你的年龄:");
        age = sc.nextInt();

        double money = 0;
        System.out.print("请输入你的工资:");
        money = sc.nextDouble();

        sc.close();//Scanner是一种资源，用完之后 关闭比较好，类似于C语言的文件

        System.out.println();
        System.out.println("姓名:" + name);
        System.out.println("年龄:" + age);
        System.out.println("工资:" + money);
    }*/



    /*public static void main(String[] args) {
        for (long i = 0L; i < 1000000000L; i++) {
            double q = Math.random();
            if (q >= 1)
            {
                System.out.println(q);
            }
        }
    }*/


    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong())
        {
            long q = sc.nextLong();
            System.out.println(q);
        }
        //字符串的是sc.hasNextLine()
        //整数的是sc.hasNextInt()
        //小数的是sc.hasNextDouble()
        //长整型是sc.hasNextLong()
    }*/
}