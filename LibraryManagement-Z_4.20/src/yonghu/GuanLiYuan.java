package yonghu;

import caozuo.*;

import java.util.Scanner;

public class GuanLiYuan extends YongHu {
    public GuanLiYuan(String name) {
        super(name);
        this.iXuanZeQi = new IXuanZeQi[] {
                new exit(),
                new chaZhao(),
                new add(),
                new del(),
                new xianShi(),
        };
    }
    public int menu() {
        System.out.println("管理员菜单");
        System.out.println("=====================");
        System.out.println("Hello " + this.name + " 欢迎来到图书管理小练习！");
        System.out.println("1、查找图书");
        System.out.println("2、新增图书");
        System.out.println("3、删除图书");
        System.out.println("4、显示图书");
        System.out.println("0、退出系统");
        System.out.println("=====================");
        System.out.print("请选择->");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
