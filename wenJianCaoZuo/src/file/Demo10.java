package file;

import jdk.nashorn.internal.ir.IfNode;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
// 读取文件 A 到文件 B 中
public class Demo10 {
    private static File solver(String curMuLu) throws IOException {
        // 如果存在这个目录，就直接返回
        File curFile = new File(curMuLu);
        // 判断目标文件的目录是否存在
        if (!curFile.getParentFile().isDirectory()) {
            System.out.println("目标路径输入错误!!!");
            return null;
        }
        if (curFile.isFile()) {
            return curFile;
        }
        // 创建出这个文件
        curFile.createNewFile();
        return curFile;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入要复制的源文件路径->");
        String curF = sc.nextLine();
        File luJing = new File(curF);
        sc.nextLine();
        if (!luJing.isFile()) {
            System.out.println("您输入的源文件路径错误!!!");
            return;
        }

        System.out.print("请输入复制到的目标路径->");
        // 开始转移
        File curMuLu = solver(sc.next());
        if (curMuLu == null) {
            return;
        }
        try (
                InputStream inputStream = Files.newInputStream(luJing.toPath());
                OutputStream outputStream = Files.newOutputStream(curMuLu.toPath());
        ) {
            // 按照字节流读取
            while (true){
                byte[] buf = new byte[819200000];
                int n = inputStream.read(buf);
                if (n == -1) {
                    System.out.println("读取结束!!!");
                    break;
                }
                outputStream.write(buf, 0, n);
            }
            // 以字符流来复制的，不能复制图片等信息
                /*InputStream inputStream = Files.newInputStream(luJing.toPath());
                Writer writer = new FileWriter(curMuLu);
                ) {
            sc = new Scanner(inputStream);
            while (sc.hasNext()){
                String st = sc.nextLine();
                writer.write(st);
            }*/
        }
    }
}
/*
InputStream：字节流读取文件信息
OutputStream：字节流写入文件信息
Reader：字符流读取
Writer：字符流读取
 */