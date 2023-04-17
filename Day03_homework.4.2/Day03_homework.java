import java.util.Scanner;
public class Day03_homework {
    /*public static void main(String[] args) {

        //身高是具有遗传性的，子女的身高和父母的身高有一定的关系。假定，父母和子女的身高遗传关系如下：
        //儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2
        //女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2
        //现有父亲身高177CM,母亲身高165CM。求子女身高分别预计为多少？
        double son = 0;
        double girl = 0;
        double fatherHight = 0;
        double motherHight = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入您的身高->");
        fatherHight = sc.nextInt();

        System.out.println("请输入您夫人的身高->");
        motherHight = sc.nextInt();

        //儿子身高（厘米）＝(父亲身高＋母亲身高) ×1.08÷2
        double sonHeight = ((fatherHight + motherHight) * 1.08) / 2;

        //女儿身高（厘米）＝(父亲身高×0.923＋母亲身高) ÷2
        double girlHeight = ((fatherHight * 0.923) + motherHight) / 2;

        System.out.println("儿子身高预计是->" + sonHeight);
        System.out.println("女儿身高预计是->" + girlHeight);
    }*/


    //红茶妹妹有21元钱，她攒了几天钱之后自己的钱比原来的两倍还多三块。
    //绿茶妹妹有24元钱，她攒了几天钱之后自己的钱正好是原来的两倍。
    //那么红茶和绿茶现在的钱一样多，请问对么？

    /*public static void main(String[] args) {
        int blackMoney = 21;
        blackMoney *= 2;
        blackMoney += 3;
        int greenMoney = 24;
        greenMoney *= 2;
        String newMoner = blackMoney == greenMoney ? "对" : "不对";
        System.out.println("红茶妹妹和绿茶妹妹现在的钱一样多，请问对么?->" + newMoner);

    }*/



    //某小伙想定一份外卖，商家的优惠方式如下：
    //鱼香肉丝单点24元，油炸花生米单点8元，米饭单点3元。
    //订单满30元8折优惠。鱼香肉丝优惠价16元，但是优惠价和折扣不能同时使用。
    //那么这个小伙要点这三样东西，最少要花多少钱？
    /*public static void main(String[] args) {
        double scheme1 = (24 + 8 + 3) * 0.8;
        double scheme2 = 16 + 8 + 3;
        double money = (scheme1 > scheme2 ? scheme2 : scheme1);
        System.out.println("最少要花" + money + "元");
    }*/



    //数字6是一个真正伟大的数字，键盘录入两个整数。
    //如果其中一个为6，最终结果输出true。
    //如果它们的和为6的倍数。最终结果输出true。
    //其他情况都是false。
    /*public static void main(String[] args){
        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个数字:");
        a = sc.nextInt();
        System.out.println("请输入第二个数字:");
        b = sc.nextInt();
        if ((a == 6) || (b == 6) || (a + b) % 6 == 0)
        {
            System.out.println(true);
        }
        else
        {
            System.out.println(false);
        }
    }*/



    //需求：键盘录入一个三位数，求这个三位数每一位的数字和。
    //举例：键盘录入123。那么每一位数字相加为：1 + 2 + 3，和为：6。
    public static void main(String[] args) {
        int i = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字:");
        i = sc.nextInt();
        int[] arr=new int[9999];
        int size = 0;
        for (; i > 0; )
        {
            arr[size++]= (i % 10);
            i /= 10;
        }
        int num = 0;
        for (size--; size >= 0; size--)
        {
            num += arr[size];
        }
        System.out.println("和为:" + num);
    }








}
