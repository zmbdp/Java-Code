package yonghu;

import caozuo.*;

import java.util.Scanner;

public class PuTongYongHu extends YongHu{
    public PuTongYongHu(String name) {
        super(name);
        this.iXuanZeQi = new IXuanZeQi[] {
                new exit(),
                new chaZhao(),
                new jieYue(),
                new guiHuan(),
        };
    }
    @Override
    public int menu() {
        System.out.println("普通用户菜单");
        System.out.println("=====================");
        System.out.println("Hello " + this.name + " 欢迎来到图书小练习！");
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
