package demo3;

interface IRunning {
    void run();
}
public interface IFlying {
    void fying();

}
interface ISwimming {
    void swim();

}

abstract class Animal {
    private String name;
    private int age;
    public abstract void eat();

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Dog extends Animal implements IRunning, ISwimming{
    public Dog(String name, int age) {
        super(name,age);
    }

    @Override
    public void eat() {
        System.out.println(super.getName() + "正在吃狗屎");
    }

    @Override
    public void run() {
        System.out.println(super.getName() + "正在跑");
    }

    @Override
    public void swim() {
        System.out.println(super.getName() + "正在游泳");
    }
}

class Brid extends Animal implements IFlying{

    public Brid(String name, int age) {
        super(name, age);
    }

    @Override
    public void fying() {
        System.out.println(super.getName() + "在飞");
    }

    @Override
    public void eat() {
        System.out.println(super.getName() + "正在吃鸟屎");
    }
}


class Robot implements IRunning {
    private final String name;
    //private final int age;

    public Robot(String name, int age) {
        this.name = name;
        //this.age = age;
    }
    @Override
    public void run() {
        System.out.println(this.name + "机器人正在跑步");
    }
}




















