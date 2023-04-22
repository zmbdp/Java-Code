package caozuo;

import shujia.Shu;
import shujia.ShuJia;

import java.util.Scanner;

public class xianShi implements IXuanZeQi {
    @Override
    public void xuanZe(ShuJia shuJia) {
        int count = shuJia.getShuSize();
        for (int i = 0; i < count; i++) {
            Shu shu = shuJia.getShu(i);
            System.out.println(shu.toString());
        }
    }
}
