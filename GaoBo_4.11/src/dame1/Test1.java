package dame1;
import java.util.*;
class Student {
    public static String banji;
    public int a = 0;
    public void prinf() {
        System.out.println(Student.banji);
    }
    public static void printgg() {
        //System.out.println(Student.a);//无法从静态方法里引用非静态变量！！！
        System.out.println(Student.banji);
    }
}
public class Test1 {
    public static void main(String[] args) {
        Student st = new Student();
        Student.printgg();
    }

}
