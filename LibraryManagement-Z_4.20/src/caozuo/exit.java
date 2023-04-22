package caozuo;

import shujia.ShuJia;

public class exit implements IXuanZeQi {
    @Override
    public void xuanZe(ShuJia shuJia) {
        System.out.println("退出程序！");
        System.exit(0);
    }
}
