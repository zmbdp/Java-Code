import java.io.*;
import java.util.Scanner;

public class MyDemo {
    // 得在指定的目录中查找每个文件里面是否包含那个字符
    private static void searching(File file, String myFind) throws IOException {
        // 先按照字符流的方式来打开这个文件
        Reader reader = new FileReader(file);

        while (true) {
            char[] buf = new char[81920000];
            int n = reader.read(buf);
            if (n == -1) {
                break;
            }
            String st = new String(buf, 0, n);
            // 如果名字或者内容中有这个 myFind 就全部写出来
            if (st.contains(myFind) || file.getName().contains(myFind)) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    private static void solver(File file, String myFind) throws IOException {
        if (file.isFile()) {
            searching(file, myFind);
        }
        // 进来先判断 file 是否为空，或者文件是否为空
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File x : files) {
            if (x.isDirectory()) {
                // 如果是目录，就直接递归
                solver(x, myFind);
            }
            else {
                // 不是递归就进去判断这个文件中是否有需要找的字符
                searching(x, myFind);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("请输入指定目录->");
        Scanner sc = new Scanner(System.in);
        File file = new File(sc.nextLine());
        System.out.print("请输入需要查找的字符->");
        String myFind = sc.nextLine();

        solver(file, myFind);
    }
}
