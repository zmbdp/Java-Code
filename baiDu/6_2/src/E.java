import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] fu = new int[n];
        int[] zheng = new int[n];
        int f = 0;
        int z = 0;
        int s = 0;
        while (s < n) {
            int num = sc.nextInt();
            if (num <= 0){
                fu[f] = num;
                f++;
            }
            if (num > 0) {
                zheng[z] = num;
                z++;
            }
            s++;
        }
        Arrays.sort(fu, 0, f);
        Arrays.sort(zheng, 0, z);
        for (int i = 0; i < f; i++) {
            if (i == 0){
                int cur = fu[0];
                fu[0] += fu[i + 1];
                fu[i + 1] = cur;
            }
            else {
                int cur = fu[0];
                fu[0] += fu[i];
                fu[i] = cur;
            }
        }
        if (f == 1) {
            fu[0] += zheng[0];
        }
        for (int i = 0; i < z; i++) {
            int cur = zheng[z - 1];
            zheng[z - 1] += zheng[i];
            zheng[i] = cur;
        }
        if (z >= 2){
            zheng[z - 1] += zheng[z - 2];
        }

        if (f > 0 && z > 0) {
            System.out.println(zheng[z - 1] - fu[0]);
        }
        else if (f > 0) {
            Arrays.sort(fu, 0, f);
            System.out.println(fu[f - 1] - fu[0]);
        }
        else if (z > 0) {
            System.out.println(zheng[z - 1] - zheng[0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            solve();
        }
    }
}