package Dame;
class Test1 {
    private int data1 = 1;
    int data2 = 2;
    public static int data3 = 3;
    static class print {
        private int data4 = 4;
        int data5 = 5;
        public static int data6 = 6;
        public static void prinf() {
            Test1 tt = new Test1();
            Test1.print tp = new Test1.print();
            System.out.println(tt.data1);
            System.out.println(tt.data2);
            System.out.println(Test1.data3);
            System.out.println(tp.data4);
            System.out.println(tp.data5);
            System.out.println(Test1.print.data6);
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
        Test1.print.prinf();
    }
}
