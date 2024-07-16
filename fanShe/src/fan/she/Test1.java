package fan.she;

class Student{
    // 私有属性name
    private String name = "付豪";
    // 公有属性age
    public int age = 19;
    // 不带参数的构造方法
    public Student(){
        System.out.println("Student()// 不带参数");
    }
    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)// 带参数");
    }
    private void eat(){
        System.out.println("i am eat");
    }
    public void sleep(){
        System.out.println("i am pig");
    }
    private void function(String str) {
        System.out.println(str);
    } @
            Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException{
        // 1、通过类的引用去给、获取
        Student student = new Student();
        Class<?> c1 = student.getClass();

        // 2、直接通过类名 + " . " 获取
        Class<?> c2 = Student.class;

        // 3、通过 forName 方法获取
        Class<?> c3 = Class.forName("fan.she.Student");

        // 总结-> 类的对象只有一个
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
        System.out.println(c3 == c2);
    }
}
