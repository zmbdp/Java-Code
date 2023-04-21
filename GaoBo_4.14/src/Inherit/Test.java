package Inherit;


import java.sql.SQLOutput;

class Animal {
    public static String name;
    public static int age;
    public void barks() {
        System.out.println(Animal.name + "在吃饭");
    }
}
class Dog extends Animal{
    public void dogBarks() {
        System.out.println(Animal.name + "汪汪叫" + "年龄是：" + Animal.age);
    }
}
class Cat extends Animal{
    public void catchMice() {
        System.out.println(Animal.name + "抓老鼠" + "年龄是：" + Animal.age);
    }
}
/*public*/ class Test1 {
    public static void main(String[] args) {
        Animal.name = "狗";
        Animal.age = 10;
        Dog dog = new Dog();
        dog.dogBarks();
        dog.barks();
        Animal.age = 7;
        Animal.name = "猫";
        Cat cat = new Cat();
        cat.catchMice();
        cat.barks();
    }
}




class Anim {
    //static int a;
    public int a;
    public int b;
    public Anim(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
class Pri extends Anim {
    /*@Override
    public String toString() {
        return "swedsfads";
    }*/
    /*int a;*/
    public Pri(int a, int b) {
        super(a, b);
    }
    int c;
    int d;
    public void prif() {
        //super.a = 10;
        //super.b = 20;
        c = 30;
        d = 40;          //这个a表示子类的a
        System.out.println(super.a + "，" + super.b + "，" + c + "，" + d);
        System.out.println(super.a);//super修饰表示父类的a
    }
}

public class Test {
    public static void main(String[] args) {
        Pri pr = new Pri(4,9);
        pr.prif();
        //System.out.println(pr);
    }
}






























