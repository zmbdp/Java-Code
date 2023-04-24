package neibulei;

interface Shape {//因为这只是个接口，class是修饰类的，所以这里不能加class
    void drow();
}
public class Test3 {
    public static void main(String[] args) {
        int a = 10;
        //匿名内部类
        new Shape() {
            @Override
            public void drow() {
                //a = 90;//在匿名内部类当中，不能修改外面的成员变量
                System.out.println("Test3::drow" + a);
            }
        }.drow();//调用drow方法
    }
}
