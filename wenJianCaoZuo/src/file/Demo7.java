package file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
// 写入文件信息
public class Demo7 {
    public static void main(String[] args) throws IOException {
        try (
                // Writer writer = new FileWriter("c:/java文档/wenJianCaoZuo/testqqppooq.txt");
                // 按照追加的方式打开进行写入
                Writer writer = new FileWriter("c:/java文档/wenJianCaoZuo/testqqppooq.txt", true);
                ){
            // writer 可以一次性写一个字符串
            String st = new Scanner(System.in).nextLine();
            writer.write(st);
        }
    }
}
