import caozuo.IXuanZeQi;
import yonghu.GuanLiYuan;
import yonghu.PuTongYongHu;
import yonghu.YongHu;
import shujia.ShuJia;
import java.util.Scanner;

public class Main {
    public static YongHu shuru() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入姓名->");
        String name = sc.nextLine();
        System.out.print("1：管理员 0：普通人员" + "\n" + "请输入身份->");
        int choice = sc.nextInt();
        if (choice == 1) {
            return new GuanLiYuan(name);
        }
        else {
            return new PuTongYongHu(name);
        }
    }
    public static void main(String[] args) {
        ShuJia shuJia = new ShuJia();
        YongHu yongHu = shuru();
        while (true) {
            int xuanze = yongHu.menu();
            yongHu.caoZuo(xuanze, shuJia);//看是什么类型的用户就调用什么选择器}
        }
    }
}
