package neibulei;
//局部内部类
public class Test2 {
    public static void main(String[] args) {
        /*public */class A2 {//局部内部类不能加public、private等修饰语
            public int demo1 = 10;
        }
        A2 a2 = new A2();
        System.out.println(a2.demo1);
    }
}
