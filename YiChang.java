import java.util.InputMismatchException;
import java.util.Scanner;

public class YiChang {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("=========开始=========");
    try {
        int a = sc.nextInt();
        int ret = 10 / a;
        System.out.println("ret->" + ret);
    } catch (ArithmeticException e) {
        e.printStackTrace();
        System.out.println("我捕获到了分母为0 -> ArithmeticException的异常");
    } catch (NullPointerException e) {
        System.out.println("我捕获到了空指针 -> NullPointerException异常");
        e.printStackTrace();
    } catch (InputMismatchException e) {
        System.out.println("输入参数异常 -> InputMismatchException异常");
        e.printStackTrace();
    } finally {
        sc.close();//Scanner也是一个类，打开就要释放
        System.out.println("finally执行了！");
    }
    System.out.println("=========结束=========");
}



    public static void main2(String[] args) {
        String str = null;
        try {
            System.out.println(10/0 + str.length());
            System.out.println(str.length());//如果上面有异常是执行不到这里的
        } catch (ArithmeticException e) {//直接跳到这里捕获异常了，判断你是什么异常，如果你自己写的这戏异常都没匹配到，就交给JVM去处理了
            e.printStackTrace();//判断异常在第几行
            System.out.println("我捕获到了分母为0，ArithmeticException的异常");
        } catch (NullPointerException e) {
            e.printStackTrace();//判断异常在第几行
            System.out.println("我捕获到了空指针，NullPointerException异常");
        } catch (Exception e) {//所有异常的父类，可以捕获所以异常，要是前面没捕获到，它可以兜底
            e.printStackTrace();
            System.out.println("前面没有捕获到异常，被Exception捕获到了");
        }


        try {
            System.out.println(str.length());
        } catch (ArithmeticException e) {
            e.printStackTrace();//判断异常在第几行
            System.out.println("我捕获到了分母为0，ArithmeticException的异常");
        } catch (NullPointerException e) {
            e.printStackTrace();//判断异常在第几行
            System.out.println("我捕获到了空指针，NullPointerException异常");
        } catch (Exception e) {//不管是哪个catch，都能捕获它自己和它子类异常，所以这个才能兜底
            e.printStackTrace();
            System.out.println("前面没有捕获到异常，被Exception捕获到了");
        } finally {//不管前面是有异常finally都能执行
            System.out.println("finally执行了！");
        }

    }



    public static void main0(String[] args) {
        int a = 10;
        if (a == 10) {
            throw new NullPointerException("空指针异常");//throw：抛出自定义异常，这段代码的意思为抛出空指针异常
        }
    }
}
