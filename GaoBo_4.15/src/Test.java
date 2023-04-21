class A1 {
    public int a;
    private int q;
    public void A() {
        System.out.println("aaaa");
    }
}
class B1 extends A1 {
    public int b;
    public void B() {
        System.out.println("bbbb");
    }
}
class C1 extends A1 {
    public int c;
    public void C() {
        System.out.println("ccc");
    }
}
class Test1 extends A1{
    public static void main(String[] args) {
        A1 a1 = new Test1();
        //System.out.println(a1.q);

        //a1.B;//向上转型之后，不能找子类特有的方法和属性
    }
}

class Base1 {
    Base1() {
        System.out.print("Base");
    }
}
class Test2 extends Base1 {
    public static void main1( String[] args ) {
        new Test2();
        new Base1();
    }
}
class Base2{
    public Base2(String s){
        System.out.print("B");
    }
}
class Test3 extends Base2{
    public Test3 (String s) {
        super(s);
        System.out.print("D");
    }
    public static void main(String[] args){
        new Test3("C");
    }
}



class X{
    Y y=new Y();//1
    public X(){//2
        System.out.print("X");
    }
}
class Y{
    public Y(){//3
        System.out.print("Y");
    }
}
public class Test extends X{
    Y y=new Y();//4
    public Test(){//5
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new Test();
    }
}
















