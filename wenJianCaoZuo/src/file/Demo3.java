package file;

import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        File file = new File("./testDar/111/222/333");

        // 创建目录(文件夹)
        // file.mkdir();// 一次只能创建一层目录
        file.mkdirs();// 可以创建多级目录
    }
}
