package demo2;

public interface IUSB {
    //static {}//接口中不能有静态代码块，会报错
    //{}//实例代码块也不能有
    //public IUSB() {}//接口中不能有构造方法，因为这里不需要要初始化，子类成员全是默认public static final的，子类不能重写
    void openDevice();
    void closeDevice();
}
