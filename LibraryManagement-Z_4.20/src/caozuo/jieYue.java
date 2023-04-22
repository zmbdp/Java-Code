package caozuo;

import shujia.Shu;
import shujia.ShuJia;

import java.util.Scanner;

public class jieYue implements IXuanZeQi {
    @Override
    public void xuanZe(ShuJia shuJia) {
        System.out.print("请输入你要借阅的书籍->");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (int i = 0; i < shuJia.getShuSize(); i++) {
            Shu shu = shuJia.getShu(i);
            if (shu.getName().equals(name)) {
                shu.setZhuangtai(false);
                System.out.println("借阅成功！");
                break;
            }
        }
    }
}
