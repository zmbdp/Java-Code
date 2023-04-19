import dame1.Test1;

import java.util.*;
/*class Dog {
    public String name;
    public String color;//颜色
    public void barks() {
        System.out.println(name + "在汪汪叫!");
    }
    public void wag() {
        System.out.println(name + "在摇尾巴!");
    }

    *//*public static void main(String[] args) {

    }*//*  //这个可以有，也可以没有, 一般是全都定义在一个类里面
}
                            //主类(梦泪)
public class GaoBo {
    //这样子才是正确写法
    public String name;
    public String color;//颜色
    public void barks() {
        System.out.println(name + "在汪汪叫!");
    }
    public void wag() {
       System.out.println(name + "在摇尾巴!");
    }

    public static void main(String[] args) {
        //申请一个dog的空间
        //Dog是类名,后面的dog可以认为是重命名
        {
            Dog dog = new Dog();
            dog.name = "阿黄";
            dog.color = "黄色";
            System.out.println(dog.name);
            System.out.println(dog.color);
            dog.barks();
            dog.wag();
        }
        System.out.println("————————————————————————————————————————————————————————————————————————————");


        //在高博里面定义的
        {
            GaoBo gao = new GaoBo();
            gao.name = "高博";
            gao.color = "黄色";
            System.out.println(gao.name);
            System.out.println(gao.color);
            gao.barks();
            gao.wag();
        }
    }
}*/


/*class OutputDate {
    int year;
    int month;
    int day;
    public void setData(int year, int month, int day) {
        this.year = year;
        this.month = month;//this：谁调用该方法，谁就是this，编译器自动传参，所以加上this更保险
        this.day = day;
    }
    public void printData() {
        System.out.println(this.year + "—" + this.month + "—" + this.day);
    }
}


public class GaoBo {
    public static void main(String[] args) {
        OutputDate Data1 = new OutputDate();
        OutputDate Data2 = new OutputDate();
        OutputDate Data3 = new OutputDate();
        OutputDate Data4 = new OutputDate();
        OutputDate Data5 = new OutputDate();
        OutputDate Data6 = new OutputDate();

        Data1.setStuIn(2021,2,1);
        Data2.setStuIn(2022,2,2);
        Data3.setStuIn(2023,2,3);
        Data4.setStuIn(2024,2,4);
        Data5.setStuIn(2025,2,5);
        Data6.setStuIn(2026,2,6);

        Data1.printData();
        Data2.printData();
        Data3.printData();
        Data4.printData();
        Data5.printData();
        Data6.printData();
    }
}*/



/*class StudentInformation {//学生信息
    String name;
    String sex;
    int age;
    double height;
    public StudentInformation() {//构造方法,系统会给默认为null的值，但是自己写更安全点
        this.name = null;
        this.sex = null;
        this.age = 0;
        this.height = 0.0;
    }
    public void setStuIn(String name, String sex, int age, double height) {//赋值
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.printStuIn();
    }
    public void printStuIn() {
        System.out.println("姓名:" + this.name + "\n性别:" + this.sex + "\n年龄:" + this.age + "\n身高:" + this.height);
        System.out.println("————————————————————");
    }
}


public class GaoBo {
    public static void main(String[] args) {
        StudentInformation SI1 = new StudentInformation();
        StudentInformation SI2 = new StudentInformation();
        StudentInformation SI3 = new StudentInformation();
        StudentInformation SI4 = new StudentInformation();

        SI1.setStuIn("张三","男性",18,1.73);
        SI2.setStuIn("李四","男性",19,1.71);
        SI3.setStuIn("王五","男性",18,1.67);
        SI4.setStuIn("老六","男性",17,1.66);

    }*/



class Student {
    private String name;//private：只在当前类有效，封装他，让别人不能随意修改
    private int age;
    public Student() {

    }
    public Student(int x) {
        System.out.println(x);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class GaoBo {
    public static void main(String[] args) {
        /*Test1 te = new Test1();
        System.out.println(te.a);*/
        Student sd = new Student();
        sd.setName("付豪");
        System.out.println(sd.getName());
        sd.setAge(19);
        System.out.println(sd.getAge());
    }
}















