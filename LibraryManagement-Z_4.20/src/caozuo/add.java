package caozuo;

import com.sun.org.apache.bcel.internal.generic.NEW;
import shujia.Shu;
import shujia.ShuJia;

import java.util.Scanner;

public class add implements IXuanZeQi {
    @Override
    public void xuanZe(ShuJia shuJia) {
        int count = shuJia.getShuSize();
        Scanner sc = new Scanner(System.in);
        System.out.print("书名->");
        String name = sc.nextLine();

        System.out.print("作者->");
        String zuozhe = sc.nextLine();//作者

        System.out.print("类型->");
        String leixing = sc.nextLine();//类型

        System.out.print("价格->");
        double jiage = sc.nextDouble();//价格

        Shu shu = new Shu(name,zuozhe,jiage,leixing);
        shuJia.setShu(shuJia.getShuSize(),shu);
        shuJia.setShuSize(shuJia.getShuSize() + 1);
        System.out.println("添加完毕！");
    }
}
