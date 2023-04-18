import java.util.Scanner;
//if()  else语句作业
/*public class Day04_homework {
 *//* public static void main(String[] args) {
        //题目：
        //李雷想买一个价值7988元的新手机，
        //她的旧手机在二手市场能卖1500元，
        //而手机专卖店推出以旧换新的优惠，
        //把她的旧手机交给店家，新手机就能够打8折优惠。
        //为了更省钱，李雷要不要以旧换新？请在控制台输出
        double discount = 0;//打折价
        double thrift = 0;//卖掉的二手价
        thrift = 7988 - 1500;
        discount = 0.8 * 7988;
        boolean money = thrift < discount;
        if (money)
        {
            System.out.println("为了更省钱，要换新");
        }
        else
        {
            System.out.println("为了更省钱，不要换新");
        }
    }*//*


 *//*public static void main(String[] args) {
        //让用户依次录入三个整数，求出三个数中的最小值，并打印到控制台
        int a = 0;
        int b = 0;
        int c = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数->");
        a = sc.nextInt();
        System.out.println("请输入第二个数->");
        b = sc.nextInt();
        System.out.println("请输入第三个数->");
        c = sc.nextInt();
        int min = a > b ? b : a;
        min = min < c ? min : c;
        System.out.println("最小的是->" + min);
    }*//*


 *//*public static void main(String[] args) {
        //某银行推出了整存整取定期储蓄业务，其存期分为一年、两年、三年、五年，到期凭存单支取本息。存款年利率表如下：
        //存期		年利率（%）
        //一年		2.25
        //两年		2.7
        //三年		3.25
        //五年		3.6
        //请存入一定金额（1000起存），存一定年限（四选一），计算到期后得到的本息总额。
        //提示：
        //存入金额和存入年限均由键盘录入
        //本息计算方式：本金+本金×年利率×年限
        int year = 0;
        Scanner sc = new Scanner(System.in);
        double money = 0.0;
        System.out.println("请问你有多少钱?->");
        money = sc.nextInt();
        if (money >= 1000)
        {
            System.out.println("请问你要存几年?->");
            year = sc.nextInt();
            if (year == 1)
            {
                System.out.println(year + "一年能拿" + (money + (money * 2.25 * 1)) + "元");
            }
            else if (year == 2)
            {
                System.out.println(year + "年能拿" + (money + (money * 2.7 * 2)) + "元");
            }
            else if (year == 3)
            {
                System.out.println(year + "年能拿" + (money + (money * 3.25 * 3)) + "元");
            }
            else if (year == 4)
            {
                System.out.println(year + "年能拿" + (money + (money * 3.25 * 4)) + "元");
            }
            else if (year >= 5)
            {
                System.out.println(year + "年能拿" + (money + (money * 3.6 * year)) + "元");
            }
        }
        else
        {
            System.out.println("钱太少，滚吧你");
            System.out.println(1000 + (1000 * 3.6 * 8));
        }
    }*//*


 *//*public static void main(String[] args) {
        //某商场购物可以打折，具体规则如下：
        //普通顾客购不满100元不打折，满100元打9折；
        //会员购物不满200元打8折，满200元打7.5折；
        //不同打折规则不累加计算。
        //请根据此优惠计划进行购物结算，键盘录入顾客的类别（0表示普通顾客，1表示会员）和购物的折前金额（整数即可）
        //输出应付金额（小数类型）。
        int vip = 0;
        double money = 0.0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请问你是VIP吗?->");
        vip = sc.nextInt();
        System.out.println("请问你买了多少钱?->");
        money = sc.nextInt();
        //不是VIP的待遇
        if (vip == 0)
        {
            //打折
            if (money >= 100)
            {
                System.out.println("应支付->" + (money * 0.9) + "元");
            }
            //不打折
            else
            {
                System.out.println("应支付->" + money + "元");
            }
        }
        //是VIP的待遇
        else
        {
            if (money < 200)
            {
                System.out.println("应支付->" + (money * 0.8) + "元");
            }
            else
            {
                System.out.println("应支付->" + (money * 0.7) + "元");
            }
        }
    }*//*


    public static void main(String[] args) {
        //2019年1月1日起，国家推出新的个人所得税政策，起征点上调值5000元。
        //也就是说税前工资扣除三险一金（三险一金数额假设是税前工资的10%）后
        //如果不足5000元，则不交税。
        //如果大于5000元，那么大于5000元的部分按梯度交税，具体梯度比例如下：
        //0~3000元          交税3%
        //3000~12000元      交税10%
        //12000~25000       交税20%
        //25000~35000       交税25%
        //35000~55000       交税30%
        //55000~80000       交税35%
        //超过80000的部分，交税45%
        //比如：黑马某学员入职一家企业后，税前工资是15000，
        //则他每月该交个税的部分是15000-1500-5000=8500元，
        //个税缴纳数额是3000×3%+5500×10%=640元。税后工资12860元。
        //请完成一个个税计算程序，在用户输入税前工资后，计算出他对应的纳税数额，以及税后工资为多少？
        double money = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的工资->");
        money = sc.nextInt();
        if (money >= 0)
        {
            //大于5000，要交税
            if ((money - (5000 * 0.1)) >= 5000)
            {
                //大于5000的部分
                double newmoney = ((money - (money * 0.1)) - 5000);
                //应该要收的税
                double tax = 0;

                //0~3000元          交税3%
                if (newmoney > 0)
                {
                    if (newmoney <= 3000)
                    {
                        tax = ((newmoney * 0.03) + (money * 0.1));
                        newmoney -= 3000;
                    }
                    else
                    {
                        tax = ((3000 * 0.03) + (money * 0.1));
                        newmoney -= 3000;
                    }
                }

                //3000~12000元      交税10%
                if (newmoney >= 3000)
                {
                    if (newmoney <= 12000)
                    {
                        tax = tax + (newmoney * 0.1);
                        newmoney -= 12000;
                    }
                    else
                    {
                        tax = tax + (12000 * 0.1);
                        newmoney -= 12000;
                    }
                }

                //12000~25000       交税20%
                if (newmoney >= 12000)
                {
                    if (newmoney <= 25000)
                    {
                        tax = tax + (newmoney * 0.2);
                        newmoney -= 25000;
                    }
                    else
                    {
                        tax = tax + (25000 * 0.2);
                        newmoney -= 25000;
                    }
                }

                //25000~35000       交税25%
                if (newmoney >= 25000)
                {
                    if (newmoney < 35000)
                    {
                        tax = tax + (newmoney * 0.25);
                        newmoney -= 35000;
                    }
                    else
                    {
                        tax = tax + (35000 * 0.25);
                        newmoney -= 35000;
                    }
                }

                //35000~55000       交税30%
                if (newmoney >= 35000)
                {
                    if (newmoney < 55000)
                    {
                        tax = tax + (newmoney * 0.3);
                        newmoney -= 55000;
                    }
                    else
                    {
                        tax = tax + (55000 * 0.3);
                        newmoney -= 55000;
                    }
                }

                //55000~80000       交税35%
                if (newmoney >= 55000)
                {
                    if (newmoney <= 80000)
                    {
                        tax = tax + (newmoney * 0.35);
                        newmoney -= 80000;
                    }
                    else
                    {
                        tax = tax + (80000 * 0.35);
                        newmoney -= 80000;
                    }
                }

                //超过80000的部分，交税45%
                if (newmoney > 80000)
                {
                    tax = tax + (newmoney * 0.45);
                }
                System.out.println("个税缴纳数额是:" + tax + "元" + "到手工资为:" + (money - tax) + "元");
            }
            //小于5000，不用交税
            else
            {
                System.out.println("应交税:" + (money * 0.1) + "元" + "到手工资为:" + (money - (money * 0.1)) + "元");
            }
        }
        else
        {
            System.out.println("非法输入!!!");
        }
    }
}*/


//switch语句作业
/*public class Day04_homework {
    *//*public static void main(String[] args) {
        //键盘录入三个整数,其中前两个整数代表参加运算的数据，第三个整数为要进行的运算
        //请输入第一个整数: 30
        //请输入第二个整数: 40
        //请输入您要进行的运算(1:表示加法,2:表示减法,3:表示乘法,4:表示除法): 1
        //控制台输出:30+40=70
        System.out.println("**************************************************");
        System.out.println("******       1、加法           2、减法       ******");
        System.out.println("******       3、乘法           4、除法       ******");
        System.out.println("*************         0、exit        *************");
        System.out.println("**************************************************");
        long x = 0L;//第一个数
        long y = 0L;//第二个数
        int choose = 0;//进行的运算
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数");
        x = sc.nextInt();
        System.out.println("请输入第二个整数");
        y = sc.nextInt();
        System.out.println("请输入您要进行的运算");
        choose = sc.nextInt();
        switch (choose)
        {
            case 1:
                System.out.println(x + y);
                break;
            case 2:
                System.out.println(x - y);
                break;
            case 3:
                System.out.println(x * y);
                break;
            case 4:
                System.out.println(x / y);
                break;
            case 0:
                System.out.println("退出成功!!!");
                break;
            default:
                System.out.println("输入错误!!!");
                break;
        }
    }*//*



    //求和
    *//*public static void main(String[] args) {
        //需求：
        //键盘录入两个数字number1和number2表示一个范围，求这个范围之内的数字和。
        //number1和number2不知道谁大谁小，需要先判断大小关系
        //确定大小之后，可以循环得到范围里面的每一个数
        //把每一个数字进行累加即可
        int number1 = 0;
        int number2 = 0;
        int min = 0;
        int max = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数->");
        number1 = sc.nextInt();
        System.out.println("请输入第二个数->");
        number2 = sc.nextInt();
        min = number1 < number2 ? number1 : number2;
        max = number1 > number2 ? number1 : number2;
        int sum = 0;
        for (; min <= max; min++)
        {
            sum += min;
        }
        System.out.println("和为:" + sum);
    }*//*



    //求猪年
    *//*public static void main(String[] args) {
        //已知2019年是猪年，请在控制台输出从1949年到2019年中所有是猪年的年份。
        //1949到2019有很多年？逐个判断这么多年份肯定要用循环。
        //用什么条件来判断是否是猪年？
        int startingWeek = 1949;
        for (; startingWeek <= 2019; startingWeek++)
        {
            if ((startingWeek - 2019) % 12 == 0)
            {
                System.out.println(startingWeek + "是猪年");
            }
        }
    }*//*



    // 求闰年
    *//*public static void main(String[] args) {
        //中国有闰年的说法。闰年的规则是：四年一闰，百年不闰，四百年再闰。
        //(年份能够被4整除但不能被100整除算是闰年，年份能被400整除也是闰年）。
        //请打印出1988年到2019年的所有闰年年份
        for (int year = 1988; year < 2019; year++)
        {
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))
            {
                System.out.println(year + "是闰年");
            }
        }
    }*//*
}*/





public class Day04_homework {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的税前工资：");
        //2.键盘录入税前工资
        int money = sc.nextInt();
        //3.计算应纳税部分的工资
        double before = money - (money*0.1) - 5000;
        //4.定义个税变量
        double shui = 0;
        //5.按照梯度范围计算个税数值
        if(before > 0 && before <=3000){
            shui = before * 0.03;
        }else if(before > 3000 && before <=12000){
            shui = 3000*0.03 + (before-3000) * 0.1;
        }else if(before > 12000 && before <=25000){
            shui = 3000*0.03 + 9000*0.1 +  (before-12000)*0.2;
        }else if(before > 25000 && before <=35000){
            shui = 3000*0.03 + 9000*0.1 + 13000*0.2 + (before-25000)*0.25;
        }else if(before > 35000 && before <=55000){
            shui = 3000*0.03 + 9000*0.1 + 13000*0.2 + 10000*0.25 + (before-35000)*0.3;
        }else if(before > 55000 && before <=80000){
            shui = 3000*0.03 + 9000*0.1 + 13000*0.2 + 10000*0.25 + 20000*0.3 + (before-55000)*0.35;
        }else if(before > 80000){
            shui = 3000*0.03 + 9000*0.1 + 13000*0.2 + 10000*0.25 + 20000*0.3 + 25000*0.35 + (before-80000)*0.45;
        }
        //6.计算税后工资
        double after = money - (money*0.1) - shui;
        //7.打印个税和税后工资
        System.out.println("个人所得税" + shui + "元");
        System.out.println("税后工资" + after + "元");
    }
}












