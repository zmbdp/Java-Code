package demo4;

import java.util.Arrays;

//让传过去的东西强转成Student类型的数据（本来是强转成Comparable类型的），然后下面实现Comparable接口里compareTo的代码
class Student implements Comparable<Student> {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        /*if (this.age > o.age) {
            return 1;
        }
        else if (this.age < o.age) {
            return -1;
        }
        else {
            return 0;
        }*/
        return this.age - o.age;
        //return o.name.compareTo(this.name);//根据姓名排,不会进入死循环，有重载
    }
    public static void bubbleSort(Comparable[] comparables) {//用Comparable型接受是因为Comparable是一个接口，底层有compareTo方法比较
                                //这里是可以换成 Student[] 类型的!!!用接口型只是为了代码的阅读性更高，
                                //因为要重写compareTo方法，所以只要实现了Comparable的接口的类型就都可以换
        for (int i = 0; i < comparables.length - 1; i++) {
            for (int j = i; j < (comparables.length - 1 - i); j++) {

                //这里就是使用了Comparable这个接口的底层方法->compareTo了，但是我们重写了，因为这是对象，不能比较
                if (comparables[j].compareTo(comparables[j + 1]) > 0) {
                    Comparable tmp = comparables[j + 1];
                    comparables[j + 1] = comparables[j];
                    comparables[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student arr[] = new Student[3];
        arr[0] = new Student("张三", 19, 37.1);
        arr[1] = new Student("李四", 9, 99.1);
        arr[2] = new Student("王五", 59, 77.1);
        System.out.println("排序前：" + Arrays.toString(arr));
        //Arrays.sort(arr);
        bubbleSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }
}








public class Test {
    public static void main(String[] args) {
        int arr[] = {1, 4, 2, 65, 654, 32, 67, 76};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
