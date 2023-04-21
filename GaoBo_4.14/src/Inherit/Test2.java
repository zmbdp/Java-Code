package Inherit;


import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.sql.SQLOutput;
class Ainimo {
    public String name;
    public Ainimo(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println(this.name + "正在吃饭");
    }
}
class Dog1 extends Ainimo{
    public Dog1(String name) {
        super(name);
    }
    public void print() {
        System.out.println(super.name + "正在吃狗粮");
    }
}

class Cat1 extends Ainimo{
    public Cat1(String name) {
        super(name);
    }
    public void print() {
        System.out.println(super.name + "正在吃猫粮");
    }
    public void dongzuo() {
        System.out.println("抓老鼠！");
    }

}
public class Test2 {
    public static void func(Ainimo an) {
        an.print();
    }
    public static void main(String[] args) {
        Dog1 dog = new Dog1("dog");
        Cat1 cat = new Cat1("cat");
        func(dog);
        func(cat);
        func(new Dog1("dog1"));
        func(new Cat1("cat1"));

        Cat1 cat7 = (Cat1)cat;
        cat7.dongzuo();;
    }
}






















