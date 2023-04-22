import book.BookList;
import user.AdminUser;
import user.NormalUser;
import user.User;
import java.util.Scanner;

public class Main {
    public static User login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入你的姓名->");
        String name = sc.nextLine();
        System.out.print("1：管理员  0：普通用户" + "\n" + "请输入你的身份->");
        int ues = sc.nextInt();
        if (ues == 1) {
            return new AdminUser(name);//将返回的类型强转为User
        }
        else {
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        User user = login();
        BookList bookList = new BookList();
        while (true){
            int choice = user.menu();//返回什么类型，就调用什么类型的menu
            user.chuanLian(choice, bookList);
        }
    }
}



















