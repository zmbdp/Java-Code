package file;

import java.io.File;
import java.util.Scanner;
// // 删除指定目录下的指定文件（CC talk）
public class Demo9 {
    private static Scanner sc = new Scanner(System.in);
    private static void deleteDile(File x, String word) {
        if (x.getName().contains(word)) {
            System.out.println("该文件是：" + x.getName() + "请问是否需要删除???(Y/N)->");
            String st = sc.next();
            boolean flag = false;
            do {
                flag = false;
                String s = sc.nextLine();
                if (s.contains("Y") || s.contains("y")) {
                    x.delete();
                } else if (s.contains("N") || s.contains("n")) {
                    return;
                } else {
                    System.out.print("输入错误, 请重新输入->");
                    flag = true;
                }
            } while (flag);
        }
    }

    private static void scanDir(File genMuLu, String word) {
        // 列出当前目录的内容
        File[] files = genMuLu.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File x : files) {
            System.out.println(x.getAbsolutePath());
            if (x.isFile()) {
                // 是文件就判断是不是当前文件
                deleteDile(x, word);
            }
            else {
                scanDir(x, word);
            }
        }
    }

    public static void main(String[] args) {
        boolean flag = false;
        File genMuLu = null;
        String word = null;
        do {
            flag = false;
            // 让用户输入一个根目录
            System.out.print("请输入需要搜索的根目录->");
            genMuLu = new File(sc.next());
            sc.nextLine();
            // 让用户输入要删除的文件名字
            System.out.print("请输入要删除的文件名->");
            word = sc.next();

            // 判定目录是否是有效目录
            if (!genMuLu.isDirectory()) {
                System.out.println("您输入的目录不合法，请重新输入->");
                flag = true;
            }
        } while (flag);

        // 如果合法就找这个目录里面的文件
        scanDir(genMuLu, word);
    }
}
