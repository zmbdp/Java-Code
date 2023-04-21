package Dame;

import java.sql.SQLOutput;

class Student {
    private String name = "小红";
    private int age = 19;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void print() {
        System.out.println("哈哈哈");
    }
}
public class Test3 {
    public static void main(String[] args) {
        Student st = new Student();
        System.out.println(st);
        st.print();
    }

}
