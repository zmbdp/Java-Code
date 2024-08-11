package file;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("./testqqppooq.txt");
        // 判断文件是否存在
        System.out.println(file.exists());
        // 判断 file 对象是不是普通文件
        System.out.println(file.isFile());
        // 判断 file 对象是不是普通目录，file 对象指的是双引号里面的那个东西
        System.out.println(file.isDirectory());

        File file1 = new File("C:/Java文档/wenJianCaoZuo/test.Java");
        // 创建文件 (程序运行完才会创建)
        file1.createNewFile();
        file.createNewFile();

        // 判断文件是否存在
        System.out.println(file1.exists());
        // 判断 file 对象是不是普通文件
        System.out.println(file1.isFile());
        // 判断 file 对象是不是普通目录，file 对象指的是双引号里面的那个东西
        System.out.println(file1.isDirectory());

        // 删除 file 对象的文件
        /*file1.delete();
        file.delete();*/


        // 不是立即删除，是等我们程序退出了再删除
        file.deleteOnExit();
        file1.deleteOnExit();


        Thread.sleep(3000);
        System.out.println("已结束!!!");
    }
}
