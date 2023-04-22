package deno5;


import java.util.Arrays;
import java.util.Comparator;

class Student {
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public static int myCompareTo(Student thos, Student o) {
        return thos.age - o.age;
        //return o.name.compareTo(thos.name);//根据姓名排,不会进入死循环，有重载
    }
    public static void bubbleSort(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i; j < (students.length - 1 - i); j++) {
                if (myCompareTo(students[j], students[j + 1]) > 0) {
                    Student tmp = students[j + 1];
                    students[j + 1] = students[j];
                    students[j] = tmp;
                }
            }
        }
    }
}
class ageComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}

class scoreComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return (int)(o1.score - o2.score);
    }
}

class nameComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("张三", 19, 37.1);
        Student student2 = new Student("李四", 9, 99.1);
        System.out.println("按照年龄：" + new ageComparator().compare(student1,student2));
        System.out.println("=========");
        System.out.println("按照分数：" + new scoreComparator().compare(student1,student2));
        System.out.println("=========");
        System.out.println("按照名字：" + new nameComparator().compare(student1, student2));
    }

}
