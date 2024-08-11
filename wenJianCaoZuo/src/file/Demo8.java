package file;

import java.io.File;
import java.util.Scanner;
// 删除指定目录下的指定文件（my）
public class Demo8 {
    private static Scanner sc = new Scanner(System.in);

    // 显示内容
    private static void showMuLu(File muLu) {
        File[] files = muLu.listFiles();
        if (files == null || files.length == 0) {
            // 表示当前目录为空目录或者不存在当前目录
            return;
        }
        for (File x : files) {
            // 添加日志，方便观察程序执行过程
            System.out.println(x.getAbsolutePath());
            if (!muLu.isFile()) {
                // 如果是目录，就继续往下走着看
                showMuLu(x);
            }
        }
    }

    private static File shuRu() {
        System.out.print("请输入目录->");
        File muLu = new File(sc.next());
        // 判断目录是否合法
        if (!muLu.isDirectory()) {
            // 不合法直接返回
            System.out.println("输入错误");
            return null;
        }
        // 合法就直接把目录的内容显示出来
        showMuLu(muLu);
        return muLu;
    }

    private static void deleteTxt(File file) {
        System.out.print("请输入需要删除的文件->");
        sc.nextLine();
        String cur = sc.next();
        file = new File(file + "/" + cur);
        // 先判定该目录是否是 txt
        if (!file.getName().contains(cur)) {
            System.out.println("不存在该文件!!!");
            return;
        }
        // 询问是否要删除该文件
        System.out.println("该文件是" + file.getName() + " ,是否要删除?（Y/N）");
        boolean flag = false;
        do {
            flag = false;
            String xuanZe = sc.nextLine();
            if (xuanZe.contains("Y") || xuanZe.contains("y")) {
                file.delete();
            } else if (xuanZe.contains("N") || xuanZe.contains("n")) {
                return;
            } else {
                if (!flag){
                    System.out.print("输入错误, 请重新输入->");
                }
                flag = true;
            }
        } while (flag);
    }

    public static void main(String[] args) {
        // 让用户输入一个目录
        File file = shuRu();

        // 删除用户输入的某个文件
        deleteTxt(file);
    }
}
