package neibulei;

//实例内部类
class A {
    public int demo1 = 10;
    private int demo2 = 20;
    public static int demo3 = 30;
    class B {
        public int demo1 = 1111;//当内部类和外部类重名时，优先访问内部类

        public int demo4 = 40;
        private int demo5 = 50;
        //public static int demo6 = 60;//在实例内部类中，不能定义静态成员，
        //因为静态成员在编译过程中是最先加载的，比类加载还快，
        //如果静态成员定义在内部类的话，肯定要先加载外部类才能访问到它，与前面所叙述相悖
        public static final int demo6 = 60;//给它加上final才能使用
        //final修饰的是常量，是在编译的时候就已经确定了的，保证了该变量在初始化后不可再次修改。
        //比如在运行的时候，看到demo6就知道是60，如果不加final修饰，看到demo6不能确定它是否是60，还要引用对象看具体是多少
        public void print() {
            System.out.println("print");
            System.out.println(A.this.demo1);//这样子就能访问外部类的demo1了
            //说明：实例内部类是存在外部类的this的
            System.out.println(demo1);
            System.out.println(demo2);
            System.out.println(demo3);
            System.out.println(demo4);
            System.out.println(demo5);
            System.out.println(demo6);
        }
    }
    public void Voidq() {
        B b = new B();
        System.out.println(b.demo4);//在外部类中访问内部类成员，和普通类一样访问
    }
}
public class Test {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.demo1);//通过实例化一个对象来调用里面的成员
        A.B b = new A().new B();
        //A.B：表示类型，创建一个这样的类型b
        //new A()：先实例化A
        //new A().new B()：通过实例化好的A去实例化B这个类给b这个对象，而内部类B是外部类A的一个内部类，所以b的类型就是A.B

        b.print();//实例化好了之后就可以拿到内部类B的对象，然后调用我们写在内部类里面的方法
        System.out.println(A.B.demo6);//更加印证了这句话，看到demo6就是60
    }
}


























