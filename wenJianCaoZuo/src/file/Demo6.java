package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
// 读取文件信息
public class Demo6 {
    public static void main(String[] args) throws IOException {
        try (
                InputStream inputStream = new FileInputStream("C:/Java文档/wenJianCaoZuo/testqqpwpwpw.txt");
                ) {
            /*while (true) {
                byte[] buf = new byte[1024];
                int n = inputStream.read(buf);
                if (n == -1) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.printf("%x ",buf[i]);
                }
                System.out.println();
                String str = new String(buf,0, n, "utf8");
                System.out.println(str);
            }*/
            Scanner sc = new Scanner(inputStream);
            while (sc.hasNext()){
                String st = sc.nextLine();
                System.out.println(st);
            }
        }
    }
}
