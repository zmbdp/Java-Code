package fanxing;

import java.util.Arrays;

//实现一个自己定义的数组，该数组可以存放任意数据
//这就叫泛型
class MyArrays <T>{//T是一个占位符，表示当前类是泛型类
    //Object类是包含所有，所有可以用它来存放数据
    public T[] objects = (T[]) new Object[10];//这样写的也不对，不太好，源码不是这样写的
    public void setArrays(int pos, T objects) {
        this.objects[pos] = objects;
    }
    public T getArrays(int pos) {
        return this.objects[pos];
    }

    @Override
    public String toString() {
        return "MyArrays{" +
                "objects=" + Arrays.toString(this.objects) +
                '}';
    }
}


public class Demo1 {

    public static void main(String[] args) {
        MyArrays<Integer> myArrays = new MyArrays<Integer>();//<>内的东西表示你需要存什么类型的数据
        myArrays.setArrays(0, 342323);
        System.out.println(myArrays.toString());
        MyArrays<String> myArrays1 = new MyArrays<>();//<>可删除
        myArrays1.setArrays(0, "String");
        System.out.println(myArrays1.toString());
    }


    //这样写是错误的
    public static void main1(String[] args) {
        MyArrays myArrays = new MyArrays();
        myArrays.setArrays(0,"sdkijsdfdhs");
        myArrays.setArrays(1,342323);
        myArrays.setArrays(2,3423234343243455L);
        for (int i = 0; i < myArrays.objects.length; i++) {
            System.out.print(myArrays.getArrays(i) + " ");
        }
        System.out.println();
        System.out.println(myArrays.toString());
    }
}
