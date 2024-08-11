package file;

import java.io.File;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("./testqqppooq.txt");
        File file2 = new File("./test1.txt");

        file1.createNewFile();
        // 重命名文件
        file1.renameTo(file2);

        // 还可以更改目录(移动文件)
        File file3 = new File("./test2.txt");
        File file4 = new File("./src/file/test3.txt");

        file3.createNewFile();
        file3.renameTo(file4);


    }
}
