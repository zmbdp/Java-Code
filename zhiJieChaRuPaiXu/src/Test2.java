public class Test2 {
    public String name = "abc";

    public static void main(String[] args) {
        Test2 test = new Test2();
        Test2 testB = new Test2();
        System.out.println(test.equals(testB) + "," + test.name.equals(testB.name));
    }
}