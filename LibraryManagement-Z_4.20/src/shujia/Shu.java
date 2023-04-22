package shujia;

public class Shu {
    private String name;
    private String zuozhe;//作者
    private double jiage;//价格

    private String leix;//类型

    private boolean zhuangtai;//是否被借出

    public Shu(String name, String zuozhe, double jiage, String leix) {
        this.name = name;
        this.zuozhe = zuozhe;
        this.jiage = jiage;
        this.leix = leix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZuozhe() {
        return zuozhe;
    }

    public void setZuozhe(String zuozhe) {
        this.zuozhe = zuozhe;
    }

    public double getJiage() {
        return jiage;
    }

    public void setJiage(double jiage) {
        this.jiage = jiage;
    }

    public String getLeix() {
        return leix;
    }

    public void setLeix(String leix) {
        this.leix = leix;
    }

    public boolean isZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(boolean zhuangtai) {
        this.zhuangtai = zhuangtai;
    }

    @Override
    public String toString() {
        return "Shu{" +
                "书名：" + name + '\'' +
                ", 作者：" + zuozhe + '\'' +
                ", 价格：" + jiage +
                ", 类型：" + leix + '\'' +
                ", 状态：" + (zhuangtai ? "已借出" : "未借出") +
                '}';
    }
}
