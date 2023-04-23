package demo1;

import com.sun.xml.internal.ws.api.message.MessageWritable;

import java.util.Objects;

class Money implements Cloneable {
    public double money;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return Double.compare(money1.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
class Student implements Cloneable {//Cloneable：这是空接口，被称为标记接口，实现该接口，证明该类是可以被克隆的
    public int age;
    public Money mon = new Money();
    public Student(int age) {
        this.age = age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //一、先把Student拷贝出来
        Student tmp = (Student) super.clone();
        //二、再拷贝Student的Money拷贝出来
        tmp.mon = (Money) this.mon.clone();
        //三、返回拷贝好的对象，给student2接受
        return tmp;
        //return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, mon);
    }

    @Override
    public boolean equals(Object obj) {
        Student Obj = (Student) obj;
        return (this.age == Obj.age);
    }
}
public class Test {
    public static void main(String[] args) {
        Object student1 = new Student(19);
        Object student2 = new Student(19);
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
    }
    public static void main3(String[] args) {
        Object student1 = new Student(19);
        Object student2 = new Student(9);
        System.out.println(student1.equals(student2));
    }
    public static void main2(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student(19);
        student1.mon.money = 19.9;
        Student student2 = (Student) student1.clone();

        System.out.println(student1.age);
        System.out.println(student2.age);
        System.out.println(student1.mon.money);
        System.out.println(student2.mon.money);
        System.out.println("==========");
        student1.age = 6;
        student1.mon.money = 29.9;
        System.out.println(student1.age);
        System.out.println(student2.age);
        System.out.println(student1.mon.money);
        //因为你拷贝的是Student这个对象，并没有拷贝它里面的mon所指向的Money这个对象，
        //所以age会改变，mon所指向的Money不会改变，这两个还是指向同一个地址，
        //这种就叫浅拷贝
        System.out.println(student2.mon.money);
    }



    public static void main1(String[] args) throws CloneNotSupportedException {
        Student student1 = new Student(19);
        Student student2 = (Student) student1.clone();
        System.out.println(student1);
        System.out.println(student2);
    }
}
















