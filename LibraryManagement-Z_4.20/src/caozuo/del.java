package caozuo;

import shujia.Shu;
import shujia.ShuJia;

import java.util.Scanner;

public class del implements IXuanZeQi {
    @Override
    public void xuanZe(ShuJia shuJia) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入书名->");
        String name = sc.nextLine();
        int count = shuJia.getShuSize();
        int i = 0;
        for (; i < count; i++) {
            Shu shu = shuJia.getShu(i);
            if (shu.getName().equals(name)) {
                break;
            }
        }
        if (i >= shuJia.getShuSize()){
            System.out.println("未找到书籍！");
        }
        else {
            for (int j = i + 1; j < shuJia.getShuSize(); j++, i++) {
                Shu shu = shuJia.getShu(j);
                shuJia.setShu(i,shu);
            }
            shuJia.setShuSize(shuJia.getShuSize() - 1);
            System.out.println("删除成功！");
        }
    }
}
