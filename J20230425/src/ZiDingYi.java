import java.util.Scanner;
class ZiDing {
    public void A(int a) {
        try {
            System.out.println(10 / a);
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
        System.out.println(10 / a);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("dfasf");
        stringBuffer.charAt(1);
        stringBuffer.capacity();
        stringBuffer. ensureCapacity(1);
    }
}
public class ZiDingYi {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ZiDing ziding = new ZiDing();
        try {
            ziding.A(n);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("我捕捉到了a为0的异常->ArithmeticException");
        } finally {
            sc.close();
            System.out.println("结束");
        }
    }
}