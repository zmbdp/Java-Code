package file;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo5 {
    public static void main(String[] args) throws IOException {
        /*// 打开文件
        Reader reader = new FileReader("D:/网页下载/小草神拉珠/1_1.jpg");
        try {
            // 中间的代码无论出现啥情况，都能执行到 close 方法
        } finally {
            reader.close();
        }*/

        // 上述代码虽然说能解决问题，但是不优雅
        // 最好是用 try with resource 这个解决方案来解决
        try (
                // Reader reader = new FileReader("D:/网页下载/小草神拉珠/1_1.jpg");
                Reader reader = new FileReader("c:/java文档/wenJianCaoZuo/testqqpwpwpw.txt");
                // 可以写多个文件操作
        ) {
            // 只要 try 代码块执行完毕了，就能自动调用到 close 方法


            while (true){
                char[] buf = new char[1024];
                int n = reader.read(buf);
                if (n == -1) {
                    // 表示读到文件末尾了
                    break;
                }
                // 一般都是这么读文件
                for (int i = 0; i < n; i++) {
                    System.out.print(buf[i]);
                }
                System.out.println();
                String str = new String(buf,0, n);
                System.out.println(str);
            }
        }
    }
}
