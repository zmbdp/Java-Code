package string.lei;

import java.util.Arrays;

public class demo1 {
    public static void main(String[] args) {
        //删减下标值
        String str1 = "Hello World Hello Bit.";
        String ret = str1.substring(10);//删除10下标之前的元素
        System.out.println(ret);
        ret = str1.substring(1,5);//删除1下标之前，5下标之后的元素，包左不包右
        System.out.println(ret);
        System.out.println("==================");
        System.out.println(str1.trim());//删除左右的空格，如果没有就不删
    }
    public static void main5(String[] args) {
        //字符串的替换
        String str1 = "helloworld";
        String ret1 = str1.replaceAll("l", "_");//替换全部
        System.out.println(ret1);
        String str4 = "helloworld";
        String ret4 = str4.replaceFirst("l", "_");//替换第一个
        System.out.println(ret4);
        //分割字符串
        String str2 = "Hello World Hello Bit.";
        String[] ret2 = str2.split(" ");//分割字符串
        for (int i = 0; i < ret2.length; i++) {
            System.out.println(ret2[i]);
        }
        System.out.println("==================");
        String[] ret3 = str2.split(" ",2);//分割字符串，分成两组
        for (int i = 0; i < ret3.length; i++) {
            System.out.println(ret3[i]);
        }
    }
    public static void main4(String[] args) {
        //转换
        //转换大小写
        String str1 = "abababababcabcabd";
        String ret1 = str1.replaceAll("ab", "AB");//所有ab替换成AB
        System.out.println(ret1);
        System.out.println("===================");
        String ret2 = str1.replaceFirst("ab", "AB");//第一个ab替换成AB
        System.out.println(ret2);
        System.out.println("===================");
        String ret3 = str1.replace("ab", "AB");//还是把所有的ab替换成AB
        System.out.println(ret3);
        System.out.println("===================");
        String ret4 = str1.replace('a', 'A');//替换所有单个字符成单个字符
        System.out.println(ret4);
        System.out.println("===================");
        String ret5 = str1.toUpperCase();//全部转大写
        System.out.println(ret5);
        System.out.println("===================");
        String ret6 = str1.toLowerCase();//全部转小写
        System.out.println(ret6);
        System.out.println("===================");
        //数字转字符串
        String str2 = String.valueOf(12345);
        String str3 = String.valueOf(123.45);
        System.out.println(str2);
        System.out.println(str3);
        //字符串转数字
        int data1 = Integer.parseInt("12345");
        double data2 = Double.parseDouble("123.45");
        System.out.println(data1);
        System.out.println(data2);
        //字符串转数组
        String str4 = "hello";
        char[] ch = str4.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
        }
        System.out.println();
        //数组转字符串
        char[] ch1 = {'h', 'e', 'l', 'l', 'o'};
        String str5 = new String(ch1);
        System.out.println(str5);

    }
    public static void main3(String[] args) {
        //查找
        String str1 = "Hello";
        char ch = str1.charAt(1);//返回下标的元素
        System.out.println(ch);
        System.out.println("==================");
        System.out.println(str1.indexOf('l'));//返回元素的下标
        System.out.println(str1.indexOf('l',3));//查找l的位置，从下标为3开始查
        System.out.println("==================");
        System.out.println(str1.indexOf("el"));//查找字符串,返回第一个字符的位置
        System.out.println(str1.indexOf("ll",2));//还是方法的重载
        System.out.println("==================");
        System.out.println(str1.lastIndexOf('l'));//从后往前数,返回下标
        System.out.println(str1.lastIndexOf('l',2));//从下标为2的位置开始往前数
    }
    public static void main2(String[] args) {
        //比较是否相同
        String str1 = new String("abcde");
        String str2 = new String("abcde");
        System.out.println(str1 == str2);
        System.out.println("==================");
        String str3 = "abc";
        String str4 = "abc";
        System.out.println(str3 == str4);//因为这是简写，上面的是new了一个堆，涉及到常量池的问题，不好多说
        System.out.println("==================");
        //比较大小
        String str5 = "abc";
        String str6 = "abC";
        System.out.println(str5.equals(str6));
        System.out.println(str5.compareTo(str6));
        System.out.println(str5.compareToIgnoreCase(str6));//忽略大小写
    }
    public static void main1(String[] args) {
        String str1 = "China.No1";//语法上的简写，实际上String是一个类
        String str2 = new String("China.No1");
        System.out.println(str1);
        System.out.println(str2);
        char[] cha1 = {'C', 'h', 'i', 'n', 'a', '.', 'N', 'o', '1'};
        String str3 = new String(cha1);
        System.out.println(str3);
        System.out.println("==================");
        System.out.println(str1.length());
        System.out.println(str2.length());
        System.out.println("==================");
        String str4 = "";
        System.out.println(str4.isEmpty());//判断str4里是否为空
        str4 = "China.No1";
        System.out.println(str4.isEmpty());
    }
}
