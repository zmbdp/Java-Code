package user;
import operation.*;
import java.util.Scanner;
public class NormalUser extends User{
    public NormalUser(String name) {
        super(name);
        this.iOperation = new IOperation[] {
                new ExitOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("管理员菜单");
        System.out.println("=====================");
        System.out.println("Hello " + this.name + " 欢迎来到图书管理小练习！");
        System.out.println("1、查找图书");
        System.out.println("2、借阅图书");
        System.out.println("3、归还图书");
        System.out.println("0、退出程序");
        System.out.println("=====================");
        System.out.print("请输入->");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
