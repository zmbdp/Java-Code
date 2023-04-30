package fanxing;

//以后全是这种写法，这种写法比较常用
class MyArrays1 <T>{//T是一个占位符，表示当前类是泛型类
    //Object类是包含所有，所有可以用它来存放数据
    public Object[] objects = new Object[10];//这样写的也不对，不太好，源码不是这样写的


    public void setArrays(int pos, T objects) {
        this.objects[pos] = objects;
    }
    public T getpos(int pos) {
        return (T)this.objects[pos];
    }
    public Object[] getArrays() {
        return objects;
    }
}
public class Demo2 {
    public static void main(String[] args) {
        MyArrays1<Integer> myArrays1 = new MyArrays1<Integer>();//<>内的东西表示你需要存什么类型的数据
        myArrays1.setArrays(0, 342323);
        Object[] a = myArrays1.getArrays();
        int b = myArrays1.getpos(0);
        System.out.println(b);
    }
}
