import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int[] arr = null;
        while (T-- > 0) {
            int n = sc.nextInt();
            sc.nextLine();
            arr = new int[6];
            String cur = sc.nextLine();
            for (int i = 0; i < n; i++) {
                String x = String.format("%s", cur.charAt(i));
                if (x.equals("S") || x.equals("s")) {
                    arr[0]++;
                }
                if (x.equals("h") || x.equals("H")) {
                    arr[1]++;
                }
                if (x.equals("A") || x.equals("a")) {
                    arr[2]++;
                }
                if (x.equals("N") || x.equals("n")) {
                    arr[3]++;
                }
                if (x.equals("I") || x.equals("i")) {
                    arr[4]++;
                }
                if (x.equals("G") || x.equals("g")) {
                    arr[5]++;
                }
            }
            arr[1] /= 2;
            arr[2] /= 2;
        }
        int count = 0;
        if (arr != null) {
            count = arr[0];
            for (int i = 1; i < 6; i++) {
                count = Math.min(count, arr[i]);
            }
        }
        System.out.println(count);
    }
}