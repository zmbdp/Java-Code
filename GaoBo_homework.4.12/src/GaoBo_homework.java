import java.util.*;

class Data {

    private int x;
    private int y;
    public Data(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public  int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

/*public*/ class GaoBo_homework1 {
    //修改Data类的定义
    public static void main(String[] args) {
        //需求：现有一个Data类，内部定义了属性x和y，
        //在main方法中实例化了Data类，并计算了data对象中x和y的和。
        //但是，Data类的定义存在错误，请你将这些错误修正过来，
        //使得main方法中的求和逻辑可以正常执行。
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Data data = new Data(x, y);
            System.out.println(data.getX() + data.getY());
        }
    }
}



class Student {
    private static String name;
    private static char sex;
    private static int age;

    private static double height;

    private static double weight;

    public Student() {

    }
    public Student(String name, char sex, int age, double height, double weight) {
        Student.name = name;
        Student.sex = sex;
        Student.age = age;
        Student.height = height;
        Student.weight = weight;
    }
    public void setName(String name) {
        Student.name = name;
    }
    public void setSex(char sex) {
        Student.sex = sex;
    }

    public void setAge(int age) {
        Student.age = age;
    }

    public void setHeight(double height) {
        Student.height = height;
    }

    public void setWeight(double weight) {
        Student.weight = weight;
    }

    public String getName() {
        return Student.name;
    }

    public char getSex() {
        return Student.sex;
    }

    public int getAge() {
        return Student.age;
    }

    public double getHeight() {
        return Student.height;
    }

    public double getWeight() {
        return Student.weight;
    }
}

public class GaoBo_homework {
    private static int a;
    int b;
    public GaoBo_homework() {

    }
    public GaoBo_homework(int a, int b) {
        GaoBo_homework.a = a;
        this.b = b;
    }

    public static void setA(int a) {
        GaoBo_homework.a = a;
    }
    public void setB(int b) {
        this.b = b;
    }

    public static int getA() {
        return GaoBo_homework.a;
    }
    public int getB() {
        return this.b;
    }

    public static void main(String[] args) {
        Student st = new Student();
        st.setName("稚名不带撇");
        st.setSex('男');
        st.setAge(19);
        st.setHeight(180);
        st.setWeight(60);
        System.out.println("姓名：" + st.getName());
        System.out.println("性别：" + st.getSex());
        System.out.println("年龄：" + st.getAge() + "岁");
        System.out.println("身高：" + st.getHeight() + "厘米");
        System.out.println("体重：" + st.getWeight() + "kg");
        GaoBo_homework gb1 = new GaoBo_homework();
        GaoBo_homework gb2 = new GaoBo_homework();

        GaoBo_homework.setA(19);
        //gb1.setA(19);

        gb1.setB(20);

        System.out.printf("%d\n", GaoBo_homework.getA());//输出：19
        System.out.printf("%d\n", gb1.getA());//输出：19
        System.out.printf("%d\n", gb1.getB());//输出：20

        System.out.printf("%d\n", GaoBo_homework.getA());//输出：19
        System.out.printf("%d\n", gb2.getA());//输出：19
        System.out.printf("%d\n", gb2.getB());//输出：0
        //说明static修饰的对象/方法一旦赋值，
        //如果不改变他，就会程序结束之前，就一直是这个值
    }
}















