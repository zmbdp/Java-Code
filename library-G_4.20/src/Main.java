import book.BookList;
import user.*;
import java.util.Scanner;

public class Main {
    public static User login() {//登录
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入姓名->");
        String name = sc.nextLine();
        System.out.print("1：管理员 0：普通人员" + "\n" + "请输入身份->");
        int choice = sc.nextInt();
        if (choice == 1) {
            return new AdminUser(name);//返回类型，强转为User
        }
        else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        User user = login();
        //根据choice调用指定操作
        BookList bookList = new BookList();
        while (true) {
            int choice = user.menu();//看你是什么类型的菜单，是图书管理员还是普通用户
            user.doOperation(choice, bookList);
        }
    }
}
