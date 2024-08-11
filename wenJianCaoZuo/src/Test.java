
class A {
    int i = 5;
    public A() {
        System.out.println("superA");
    }
    public int s() {
        return 8;
    }
}
public class Test extends A{
    public int s() {
        return 9;
    }
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.i * test.s());
    }
}
