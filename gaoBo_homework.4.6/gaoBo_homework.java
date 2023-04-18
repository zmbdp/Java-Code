import java.util.Objects;
import java.util.Scanner;

public class gaoBo_homework {

    //1.根据年龄,来打印出当前年龄的人是少年(低于18), 青年(19-28),中年(29-55),老年(56以上)
    public static void main1(String[] args) {
        int age = 0;
        Scanner sc = new Scanner(System.in);
        age = sc.nextInt();
        if (age <= 18 && age >= 0)
        {
            System.out.print("少年");
        }
        else if (age > 19 && age <= 28)
        {
            System.out.print("中年");
        }
        else if (age > 56)
        {
            System.out.print("老年");
        }
        else
        {
            System.out.print("输入错误!!!");
        }
    }



    //2.判定一个数字是否是素数
    public static void main2(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        int j = 2;
        for (j = 2; j <= Math.sqrt(n); j++) {
            if (n % j == 0)
            {
                break;
            }
        }
        if (j > Math.sqrt(n))
        {
            System.out.print(n + "是素数");
        }
        else
        {
            System.out.print(n + "不是素数");
        }
    }



    //3.打印1-100之间所有的素数
    public static void main3(String[] args) {
        for (int i = 2; i < 101; i++) {
            int sqRoot = 0;
            int j = 0;

            for (j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                {
                    break;
                }
            }
            if (j > Math.sqrt(i))
            {
                System.out.print(i + " ");
            }
        }
    }



    //4.输出1000-2000之间所有的闰年
    public static void main4(String[] args) {
        System.out.print("闰年有:\n");
        int count = 0;
        for (int i = 1000; i < 2001; i++) {
            if (((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0))
            {
                System.out.print(i + " ");
                count++;
                if (count % 30 == 0)
                {
                    System.out.println();
                }
            }
        }
    }



    //5.输出乘法口诀表
    public static void main5(String[] args) {
        int n = 0;
        System.out.print("几X几的乘法口诀表->");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //行
        for (int i = 1; i <= n; i++) {
            //列
            for (int j = 1; j <= i; j++) {
                if (j != 1)
                {
                    System.out.print("\t");
                }
                System.out.print(j + "X" + i + "=" + i * j + " ");
            }
            System.out.println();
        }
    }



    //6.求两个正整数的最大公约数
    public static void main61(String[] args) {
        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第一个数字->");
        a = sc.nextInt();
        System.out.print("请输入第二个数字->");
        b = sc.nextInt();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int i = 0;
        if (a <= 2 || b <= 2 || max - min == 1)
        {
            i = min;
        }
        else
        {
            for (i = min; i > 1; i--) {
                if ((max % i == 0) && (min % i == 0))
                {
                    break;
                }
            }
        }
        System.out.print(i + "是" + a + "和" + b +"的最大公约数");
    }
    //优化版：
    public static void main62(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0;
        System.out.print("请输入第一个数->");
        num1 = sc.nextInt();
        int a = num1;

        System.out.print("请输入第二个数->");
        int num2 = 0;
        num2 = sc.nextInt();
        int b = num2;

        int remainder = (num1 % num2);//余数
        while (remainder != 0)
        {
            num1 = num2;
            num2 = remainder;
            remainder = num1 % num2;//辗转相除法求
        }
        System.out.print(a + "和" + b + "的最大公约数是:" + num2);
    }



    //7.求出0~999之间的所有”水仙花数”并输出。(“水仙花数”是指一个三位数，其各位数字的立方和确身，如: 153=1^3+5^3+3^3，则153是一个“水仙花数”。)
    public static void main7(String[] args) {
        for (int i = 1; i < 999999; i++) {
            int j = i;
            int count = 0;

            //先计算出他是几位数
            while(j > 0)
            {
                count++;
                j /= 10;
            }

            j = i;
            int num = 0;
            int sum = 0;
            while (j > 0)
            {
                num = j % 10;
                j /= 10;
                sum  += Math.pow(num,count);//他的返回值是double类型的，所以要强转，+= 里面隐藏了强转
            }
            if (sum == i)
            {
                System.out.print(i + " ");
            }
        }
    }



    //8.写一个函数返回参数二进制中1的个数  比如: 15     00001111     4个1
    public static void main8(String[] args) {
        /*int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        int count = 0;
        for (int i = 31; i >= 0; i--) {
            if ((n >> i & 1) == 1)
            {
                count++;
            }
        }
        System.out.print(count + "个1");*/

        //优化版：
        /*int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        int count = 0;
        //如果移动的已经为0，就跳出循环
        while (n != 0)
        {
            if ((n & 1) != 0)
            {
                count++;
            }
            n = n >>> 1;
        }
        System.out.print(count + "个1");*/

        //超级优化版：首先来看一个二进制
        //   0111——7
        //&  0110——6
        //== 0110——6
        //&  0101——5
        //== 0100——4
        //&  0011——3
        //== 0000——0  ————————发现规律了吗
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        int count = 0;
        while (n != 0)
        {
            n = n & (n - 1);
            count++;
        }
        System.out.print(count + "个1");
    }



    //9.获取一个数二进制序列中所有的偶数位和奇数位，分别输出二进制序列。
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    public static void main9(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        n = sc.nextInt();
        //首先输出奇数位，因为从0开始，所以最高31位置
        System.out.print("二进制奇数位是->");
        for (int i = 31; i >= 1; i -= 2)
        {
            System.out.print((n >> i) & 1);
        }

        System.out.println();
        System.out.print("二进制偶数位是->");
        for (int i = 30; i >= 0; i -= 2) {
            System.out.print((n >> i) & 1);
        }
    }



    //10.计算1/1-1/2+1/3-1/4+1/5 ..... + 1/99 - 1/100的值
    public static void main10(String[] args) {
        double sum = 0;
        for (double i = 1; i < 101; i++) {
            if (i % 2 == 0)
            {
                sum -= (1 / i);
            }
            else
            {
                sum += (1 / i);
            }
        }
        System.out.print(sum);
    }



    //11.打印X图形（就是打印X）
    public static void main11(String[] args) {
        int line = 0;//行
        int row = 0;//列
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("请问需要打印几*几行的X");
        n = sc.nextInt() - 1;//因为是从第0行开始，所以要-1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if ((i == j) || ( n - j == i) || (n - i == j))//第一个是打印 '\'，第二三个打印 '/'
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }



    //12.模拟登陆
    //编写代码模拟三次密码输入的场景，最多能输入三次密码
    public static void main12(String[] args) {
        String pass;
        Scanner sc = new Scanner(System.in);
        System.out.print("请设置密码->");
        pass = sc.nextLine();
        String tru;
        System.out.print("请输入密码->");
        tru = sc.nextLine();
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            if (tru.equals(pass))//Objects.equals(tru, pass)---还可以这样表达字符串是否相等,一般用的是前者
            {
                flag = true;
                break;
            }
            else
            {
                System.out.print("输入错误，请重试->");
                tru = sc.nextLine();
                flag = false;
            }
        }
        if (flag)
        {
            System.out.println("登录成功!!!");
        }
        else
        {
            System.out.println("滚!!!");
        }
    }
}