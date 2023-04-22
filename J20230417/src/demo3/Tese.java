package demo3;

public class Tese {
    public static void testEat(Animal anim) {
        anim.eat();
    }
    public static void testRun(IRunning running) {
        running.run();
    }
    public static void testFly(IFlying flying) {
        flying.fying();
    }
    public static void testSwim(ISwimming swimming) {
        swimming.swim();
    }

    public static void main(String[] args) {
        testEat(new Dog("小黄",17));
        testSwim(new Dog("小黄",17));
        testRun(new Dog("小黄",17));

        System.out.println("==============");

        testEat(new Brid("鹦鹉",18));
        testFly(new Brid("鹦鹉",18));

        System.out.println("==============");

        testRun(new Robot("小美", 9));
    }
}



interface A {
    void testA();
}
interface B {
    void testB();
}
interface C extends A, B {//Java中只有类才只被单继承，接口可以多继承，所以不报错
    void testC();
}
class D implements C {//D不仅要实现C的方法，还要实现C的父类A和B的方法
//implements和extends的区别，前者表示要重写C里面的东西，而后者表示要继承C的东西
    @Override
    public void testA() {

    }

    @Override
    public void testB() {

    }

    @Override
    public void testC() {

    }
}




/*abstract class A {
    abstract void testA();
}
abstract class B {
    abstract void testB();
}
abstract class C extends A, B {

}*/





















