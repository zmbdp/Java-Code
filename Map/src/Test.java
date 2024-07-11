import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入->");
        char letter = sc.next().charAt(0);
        if ((letter >= 'a') && (letter <= 'z')) {
            letter -= 32;
        }
        System.out.println(letter);
    }
}
