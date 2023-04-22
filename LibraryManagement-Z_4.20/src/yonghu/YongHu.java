package yonghu;
import caozuo.IXuanZeQi;
import shujia.ShuJia;
abstract public class YongHu {
    abstract public int menu();
    protected String name;
    public IXuanZeQi[] iXuanZeQi;
    public YongHu(String name) {
        this.name = name;
    }
    public void caoZuo(int xuanze, ShuJia shujia) {
        this.iXuanZeQi[xuanze].xuanZe(shujia);
    }
}
