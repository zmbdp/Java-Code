package shujia;

import java.awt.print.Book;
import java.util.Arrays;

public class ShuJia {
    public Shu[] shu = new Shu[10];
    private int shuSize;

    public ShuJia() {
        shu[0] = new Shu("三国演义","罗贯中",29.9,"小说");
        shu[1] = new Shu("水浒传","施耐庵",29.9,"小说");
        shu[2] = new Shu("西游记","吴承恩",39.9,"小说");
        shuSize = 3;
    }

    public Shu getShu(int i) {
        return shu[i];
    }

    public void setShu(int i, Shu shu) {
        this.shu[i] = shu;
    }

    public int getShuSize() {
        return shuSize;
    }

    public void setShuSize(int shuSize) {
        this.shuSize = shuSize;
    }
}
