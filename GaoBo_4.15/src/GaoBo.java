
class A {
    public void pria() {
        System.out.println("priA");
    }public void pri() {
        System.out.println("A");
    }
}
class B extends A {
    public void prib() {
        System.out.println("priB");
    }
    public void pri() {
        System.out.println("B");
    }
}
class C extends A {
    public void pric() {
        System.out.println("priC");
    }
    public void pri() {
        System.out.println("C");
    }
}

public class GaoBo {
    public static void main(String[] args) {
        A a = new B();//向上转型
        a.pri();
        a.pria();
        //a.prib();//转型完了之后就不能调用B的特殊方法了
        if (a instanceof B){
            B b = (B)a;//向下转型
            b.pria();
            b.pri();
        }
        if (a instanceof C) {
            C c = (C) a;
            c.pric();
            c.pri();
        }
    }
}





















