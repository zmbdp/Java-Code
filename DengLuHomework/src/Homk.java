import java.util.InputMismatchException;
import java.util.Scanner;

public class Homk {
    public void login(String id, String password) {
        if (id.length() == 0 || password.length() == 0) {
            throw new NullPointerException();
        }
        if ((!id.equals("3566983494")) || (!password.equals("123456789"))) {
            throw new InputMismatchException();
        }
        if (id.equals("3566983494") && password.equals("123456789")) {
            System.out.println("登陆成功!!!");
        }
    }
    /* 自定义异常实现登录
    需求：
    实现一个简单的控制台版用户登陆程序,
    程序启动提示用户输入用户名密码.
    如果用户名密码出错, 使用自定义异常的方式来处理
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入账号->");
        String id = sc.nextLine();
        System.out.print("请输入密码->");
        String password = sc.nextLine();
        try {
            Homk homk = new Homk();
            homk.login(id, password);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("我捕捉到了用户名或密码未输入的异常->NullPointerException");
        } catch (InputMismatchException e) {
            System.out.println("我捕捉到了用户名或密码输入错误的异常->InputMismatchException异常");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("我捕捉到了不知道什么的异常->Exception");
        } finally {
            sc.close();
            System.out.println("登录结束!!!");
        }
        Integer integer = new Integer(15);
        System.out.println(integer);
        System.out.println(integer.toString());
    }
}
