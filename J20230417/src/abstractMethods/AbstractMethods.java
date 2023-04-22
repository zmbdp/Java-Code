package abstractMethods;


abstract class A {
    public abstract void a();
    //被private和static修饰的方法都不可重写
    //private abstract void q();
    //public static abstract void z();
}
abstract class B extends A {
    public abstract void b();
}
 class C extends B {
    //除非继续使用抽象类，不然就得把之前落下的抽象方法全部补上————出来混，迟早要还的
    @Override
    public void a() {

    }
    @Override
    public void b() {

    }
    public void c() {

    }
 }



public class AbstractMethods {
    
}
