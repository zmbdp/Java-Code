package demo2;
abstract class Animal {
    abstract public void eat();
}
class Dog extends Animal {
    @Override
    public void eat() {
        System.out.println("Dog::eat");
    }
}
class Duck extends Animal {
    @Override
    public void eat() {
        System.out.println("Dunk::eat");
    }
}
public class Test {

}







abstract class A {
    abstract public void a();
}
abstract class B extends A {
    abstract public void b();
}
class C extends B {

    @Override
    public void a() {

    }

    @Override
    public void b() {

    }
}

























