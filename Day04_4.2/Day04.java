import java.util.Scanner;

public class Day04 {
    //回文数：
    /*public static void main(String[] args) {
        int x = 0;//输入的数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字->");
        x = sc.nextInt();
        int[] arr=new int[9999];
        int i = 0;
        while(x > 0)
        {
            arr [i] = (x % 10);
            x /= 10;
            i++;
        }
        int zuo = 0;
        int you = i - 1;
        while(zuo < you)
        {
            if(arr[zuo] != arr[you])
            {
                System.out.println(false);
                break;
            }
            zuo++;
            you--;
        }
        if(zuo >= you)
        {
            System.out.println(true);
        }
    }*/



    /*public static void main(String[] args) {
        //无人驾驶汽车
        //需求：汽车无人驾驶会涉及到大量的判断
        //当汽车行驶的时候遇到了红绿灯，就会进行判断
        //如果红灯亮，就停止
        //如果黄灯亮，就减速
        //如果绿灯亮，就行驶
        boolean isLightGreen = false;//绿灯
        boolean isLightYello = false;//黄灯
        boolean isLightRed = true;//红灯

        if (isLightGreen)
        {
            System.out.println("Please GoGoGo");
        }
        else if (isLightYello)
        {
            System.out.println("Please Slow Down");
        }
        else if (isLightRed)
        {
            System.out.println("Please Stop");
        }
    }*/


    /*public static void main(String[] args) {
        //需求:
        //键盘录入一个整数，
        //表示身上的钱如果大于等于100块，就吃网红餐厅。
        //否则，就吃经济实惠的沙县小吃
        int money = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你现在有多少钱?->");
        money = sc.nextInt();

        if (money >=100)
        {
            System.out.println("吃网红餐厅");
        }
        else
        {
            System.out.println("吃经济实惠的沙县小吃");
        }
    }*/


    /*public static void main(String[] args) {
        //需求:
        //假设，用户在超市实际购买，商品总价为:600元键盘录入一个整数表示用户实际支付的钱
        //如果付款大于等于600，表示付款成功。否则付款失败
        int money = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请问你付款多少钱?->");
        money = sc.nextInt();
        if (money >= 600)
        {
            System.out.println("支付成功");
        }
        else
        {
            System.out.println("支付失败!!!");
        }
    }*/


    /*public static void main(String[] args) {
        //需求：在实际开发中，电影院选座也会使用到if判断
        //假设某影院售卖了100张票，票的序号为1~100
        //其中奇数票号坐左侧，偶数票号坐右侧。键盘录入一个整数表示电影票的票号根据不同情况，给出不同的提示!
        //如果票号为奇数，那么打印坐左边
        //如果票号为偶数，那么打印坐右边

        int ticket = 0;//票号
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的号码->");
        ticket = sc.nextInt();
        if (ticket >= 1 && ticket <= 100)
        {
            if (ticket % 2 == 0)
            {
                System.out.println("坐右边");
            }
            else
            {
                System.out.println("坐左边");
            }
        }
        else
        {
            System.out.println("输入号码非法!!!");
        }
    }*/



    /*public static void main(String[] args){
        //根据不同的分数送不同的礼物。
        //如果是95~100分，送自行车一辆
        //如果是90~94分，游乐场玩一天
        //如果是80~89分，送变形金刚一个。
        //如果是80分，揍一顿。
        int scores = 0;//分数
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入分数->");
        scores = sc.nextInt();
        if (scores >= 0 && scores <= 100)
        {
            if (scores >= 95 && scores <= 100)
            {
                System.out.println("送自行车一辆");
            }
            else if (scores >= 90 && scores <= 94)
            {
                System.out.println("游乐场玩一天");
            }
            else if (scores >= 80 && scores <= 89)
            {
                System.out.println("送变形金刚一个");
            }
            else
            {
                System.out.println("老子打死你个SB");
            }
        }
        else
        {
            System.out.println("分数非法!!!");
        }
    }*/


    /*public static void main(String[] args) {
        //需求:
        //商场都会有VIP的会员制，根据不同的会员会有不同的折扣
        //假设商品总价为1000
        //键盘录入会员级别，并计算出实际支付的钱
        //会员1级:打9折
        //会员2级:打8折。
        //会员3级:打7折
        //非会员:不打折，要打也是打骨折
        int vip = 0;
        int price = 1000;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你是VIP几?->");
        vip = sc.nextInt();
        if (vip >=0 && vip <= 3)
        {
            switch (vip)
            {
                case 1:
                    System.out.println("打9折" + "\n" + "打完折后的价格:" + price * 0.9);
                    break;
                case 2:
                    System.out.println("打8折" + "\n" + "打完折后的价格:" + price * 0.8);
                    break;
                case 3:
                    System.out.println("打7折" + "\n" + "打完折后的价格:" + price * 0.7);
                    break;
                default:
                    System.out.println("非会员:不打折，要打也是打骨折");
                    break;
            }
        }
    }*/


    /*public static void main(String[] args) {
        //需求：
        //选择一个想吃的面有：兰州拉面、武汉热干面、北京炸酱面、陕西油泼面
        //选择其他只能吃泡面
        String noodles = "海鲜龙虾面";
        switch (noodles)
        {
            case ("兰州拉面"):
                System.out.println("吃兰州拉面");
                break;
            case ("武汉热干面"):
                System.out.println("吃武汉热干面");
                break;
            case ("北京炸酱面"):
                System.out.println("吃北京炸酱面");
                break;
            case ("陕西油泼面"):
                System.out.println("吃陕西油泼面");
                break;
            default:
                System.out.println("吃泡面");
                break;
        }
    }*/


    //健身计划
    /*public static void main(String[] args) {
        //需求:键盘录入星期数，显示今天的减肥活动
        //周一:跑步
        //周二:游泳
        //周三:慢走
        //周四:动感单车
        //周五:拳击
        //周六: 爬山
        //周日:好好吃一顿
        int week = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入如今天星期几?->");
        week = sc.nextInt();
        if (week > 0 && week <=7)
        {
            switch (week)
            {
                case 1:
                    System.out.println("跑步");
                    break;
                case 2:
                    System.out.println("游泳");
                    break;
                case 3:
                    System.out.println("慢走");
                    break;
                case 4:
                    System.out.println("动感单车");
                    break;
                case 5:
                    System.out.println("拳击");
                    break;
                case 6:
                    System.out.println("爬山");
                    break;
                default:
                    System.out.println("好好吃一顿");
                    break;
            }
        }
        else
        {
            System.out.println("输入非法!!!");
        }
    }*/



    /*public static void main(String[] args) {
        //需求:键盘录入星期数，输出工作日、休息日
        //(1-5)工作日，(6-7)休息日。
        int week = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入今天星期几?->");
        week = sc.nextInt();
        if (week >= 1 && week <= 7)
        {
            switch (week)
            {
                case 1, 2, 3, 4, 5:
                    System.out.println("工作日");
                    break;
                default:
                    System.out.println("休息日");
                    break;
            }
        }
        else
        {
            System.out.println("输入非法!!!");
        }
    }*/


    //用户选择
    /*public static void main(String[] args) {
        //需求：
        //在实际开发中，如果我们需要在多种情况下选择其中一个，就可以使用switch语句
        //当我们拨打了某些服务电话时，一般都会有按键选择假设现在我们拨打了一个机票预定电话
        //电话中语音提示：
        //1：机票查询
        //2：机票预订
        //3：机票改签
        //4：退出服务
        //其他按键也是退出服务。请使用swtich模拟该业务逻辑
        int choose = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要的服务->");
        choose = sc.nextInt();
        switch (choose)
        {
            case 1:
                System.out.println("机票查询");
                break;
            case 2:
                System.out.println("机票预订");
                break;
            case 3:
                System.out.println("机票改签");
                break;
            default:
                System.out.println("退出服务");
                break;
        }
    }*/


    //求和：
    /*public static void main(String[] args) {
        //需求:在实际开发中，如果要获取一个范围中的每一个数据时，也会用到循环
        //比如:求1-5之间的和
        int num = 0;//记录和
        int initial = 0;//记录初始值
        int end = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入初始值->");
        initial = sc.nextInt();
        System.out.println("请输入结束值->");
        end = sc.nextInt();

        while (initial <= end)
        {
            num += initial;
            initial++;
        }
        System.out.println("和为:" + num);
    }*/



    //求所有偶数的和
    /*public static void main(String[] args) {
        //需求:
        //在实际开发中，如果要获取一个范围中的每一个数据时，会用到循环。
        //但是此时，大多情况下，不会获取所有的数据，而是获取其中符合要求的数据。
        //此时就需要循环和其他语句结合使用了
        //比如:求1-100之间的偶数和
        int num = 0;//记录和
        int initial = 0;//记录初始值
        int end = 0;//记录结束值
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入初始值->");
        initial = sc.nextInt();
        System.out.println("请输入结束值->");
        end = sc.nextInt();

        while (initial <= end)
        {
            if (initial % 2 == 0)
            {
                num += initial;
            }
            initial++;
        }
        System.out.println("和为:" + num);
    }*/



    //统计满足条件的数字
    /*public static void main(String[] args) {
        //需求:键盘录入两个数字，表示一个范围
        //统计这个范围中
        //既能被3整除，又能被5整除数字有多少个?
        int sum = 0;//记录和
        int start = 0;//记录初始值
        int end = 0;//记录结束值
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入初始值->");
        start = sc.nextInt();
        System.out.println("请输入结束值->");
        end = sc.nextInt();

        while (start <= end)
        {
            if (start % 3 == 0 && start % 5 == 0)
            {
                sum++;
            }
            start++;
        }
        System.out.println("一共有:" + sum + "个");
    }*/



    //打印折纸的次数
    /*public static void main(String[] args) {
        //需求:
        //世界最高山峰是珠穆朗玛峰(8844.43米=8844430毫米)，
        //假如我有一张足够大的纸，它的厚度是0.1毫米
        //请问，我折叠多少次，可以折成珠穆朗玛峰的高度?
        double height = 8844430;
        double paper = 0.1;
        int count = 0;
        while (paper < height)
        {
            count++;
            paper *= 2;
        }
        System.out.println("需要折" + count + "次");
    }*/



    //求商和余数
    /*public static void main(String[] args) {
        //需求:
        //定两个整数，被除数和除数(都是正数，且不超过int的范围)
        //将两数相除，要求不使用乘法、除法和% 运算符。
        //得到商和余数。

        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入被除数");
        a = sc.nextInt();
        System.out.println("请输入除数");
        b = sc.nextInt();
        int remainder = 0;//余数
        int quotient = 0;//商
        while (a >= b)
        {
            a -= b;
            quotient++;
        }
        remainder = a;
        System.out.println("商是:" + quotient);
        System.out.println("余数是:" + remainder);
    }*/
}





