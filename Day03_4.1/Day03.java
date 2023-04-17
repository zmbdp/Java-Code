import java.util.Scanner;

public class Day03 {
    /*public static void main(String[] args) {
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
        for (size--; size >= 0; size--)
        {
            System.out.println(arr[size]);
        }
    }*/


    //时髦相亲
    //需求:
    //您和您的约会对象正试图在餐厅获得一张桌子。
    //键盘录入两个整数，表示你和你约会对象衣服的时髦度。
    //(手动录入0~10之间的整数，不能录其他)
    //如果你的时毫程度大于你对象的时警程度，相亲就成功，输出true。否则输出false。

    /*public static void main(String[] args) {
        int myHipster = 0;
        int girlHipster = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的时髦度:");
        myHipster = sc.nextInt();
        System.out.println("请输入女朋友的时髦度");
        girlHipster = sc.nextInt();
        boolean judgment;
        if (myHipster > girlHipster)
        {
            judgment = true;
        }
        else
        {
            judgment = false;
        }
        if (judgment)
        {
            System.out.println("相亲成功!!!");
        }
        else
        {
            System.out.println("相亲失败...");
        }
    }*/


    //伟大的数字
    //需求：数字6是一个真正伟大的数字，
    //键盘录入两个整数如果其中一个为 6，最终结果输出true。
    //如果它们的和为6的倍数。最终结果输出true.其他情况都是false。

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



    /*//三元运算符判断老虎体重是否相等
    //需求:动物园里有两只老虎，体重分别为通过键盘录入获得
    //请用程序实现判断两只老虎的体重是否相同。
    public static void main(String[] args){
        int tiger1 = 0;
        int tiger2 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一只老虎的体重:");
        tiger1  = sc.nextInt();
        System.out.println("请输入第二只老虎的体重:");
        tiger2 = sc.nextInt();
        String maxgiter = tiger1 == tiger2 ? "相同" : "不同";
        System.out.println("体重是否相同?->" + maxgiter);
    }*/


    //三元运算符判断三人最高身高
    //需求:一座寺庙里住着三个和尚，
    //已知他们的身高分别为150cm、210cm、165cm
    //请用程序实现获取这三个和尚的最高身高。
    public static void main(String[] args) {
        int height1 = 0;
        int height2 = 0;
        int height3 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个人的身高->");
        height1 = sc.nextInt();
        System.out.println("请输入第二个人的身高->");
        height2 = sc.nextInt();
        System.out.println("请输入第三个人的身高->");
        height3 = sc.nextInt();
        int newheight1 = height1 > height2 ? height1 : height2;
        int newheight2 = newheight1 > height3 ? newheight1 : height3;
        System.out.println("这三SB最高身高是->" + newheight2);
    }


}






















