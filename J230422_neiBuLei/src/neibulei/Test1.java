package neibulei;
//静态内部类
class A1 {
    public int demo1 = 10;
    private int demo2 = 20;
    public static int demo3 = 30;
    static class B {
        public int demo4 = 40;
        private int demo5 = 50;
        public void test() {
            A1 a1 = new A1();
            System.out.println(a1.demo1);
            //和正常访问类成员一样，因为A没有被static修饰
            //所以要事先将A new一个对象出来，再来访问A中的成员
            System.out.println(a1.demo2);
            System.out.println(demo3);
            System.out.println(demo4);
            System.out.println(demo5);
        }
    }
}
public class Test1 {
    public static void main(String[] args) {
        A1.B ab = new A1.B();
        //很好理解，我们将B看作A的一个静态成员，因为是静态的，所以直接通过类名去访问就可以了
        ab.test();
    }
}
