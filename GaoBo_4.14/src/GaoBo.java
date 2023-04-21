import java.sql.SQLOutput;

class Student {
    private static String name1;
    private static int age1;

    public static void setName1(String name1) {
        Student.name1 = name1;
    }

    public static void setAge1(int age1) {
        Student.age1 = age1;
    }
    public static String getName1() {
        return name1;
    }
    public static int getAge1() {
        return age1;
    }
    /*—————————————————————————————————————————————————————————————————————————————————*/
    private String name2;

    private int age2;

    public void setName2(String name2) {
        this.name2 = name2;
    }
    public void setAge2(int age2) {
        this.age2 = age2;
    }
    public String getName2() {
        return this.name2;
    }
    public int getAge2() {
        return this.age2;
    }
    /*—————————————————————————————————————————————————————————————————————————————————*/
    class TowDog {
        static final int CONST = 0;
        //final修饰之后，相当于CONST是常量，一旦初始化，不可被修改
        //CONST = 19;
        public void dogBarks(Student st) {
            //static final int b = 0;
            System.out.println(Student.age1 + "岁的" + Student.name1 +
                    "在和" + st.age2 + "岁的" + st.name2 + "狗叫");
        }
    }
}



public class GaoBo {
    public static void main(String[] args) {
        Student st = new Student();
        Student.TowDog sd = st.new TowDog();
        Student.setName1("小黄");
        Student.setAge1(18);
        st.setName2("小红");
        st.setAge2(16);
        sd.dogBarks(st);
        System.out.println("============================");
        Student.setName1("小黄");
        Student.setAge1(18);
        st.setName2("小红");
        st.setAge2(16);
        Student.TowDog Do = new Student().new TowDog();
        Do.dogBarks(st);
    }
}
