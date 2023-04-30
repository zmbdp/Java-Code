package baozhuanglei;

public class Demo1 {
    public static void main(String[] args) {
        Integer a = 127;
        Integer b = 127;

        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b);
        System.out.println(c == d);
    }
    public static void main2(String[] args) {
        Integer i = 10;
        int a = i.intValue();//显示的拆箱
        //什么类型都可转
        float b = i.floatValue();
        double c = i.doubleValue();
        //自动的拆箱
        int ai = i;
    }
    public static void main1(String[] args) {
        int a = 9;
        //装箱
        Integer i = a;//自动装箱
        Integer ii = new Integer(a);//显示装箱（明显展示出来的装箱）
        Integer iii = Integer.valueOf(a);//显示装箱
    }
}
