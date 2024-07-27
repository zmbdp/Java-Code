import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            StringBuilder s1 = new StringBuilder(sc.next());
            String s2 = sc.next();
            char[] arr1 = s1.toString().toCharArray();
            char[] arr2 = s2.toCharArray();
            char cur = arr1[0];
            arr1[0] = arr2[0];
            arr2[0] = cur;
            String ret1 = "";
            String ret2 = "";
            for (char x : arr1) {
                ret1 += x;
            }
            for (char x : arr2) {
                ret2 += x;
            }
            System.out.println(ret1 + " " + ret2);
        }
    }
}
