import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n + 1];
        // 把数据全部存储好
        for (int i = 1; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        // 把  di 算出来
        int[] d = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            d[i] = a[i] - a[i - 1];
        }
        while (p-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            if (l >= 0){
                d[l] += x;
            }
            if ((r + 1) < d.length){
                d[r + 1] -= x;
            }
        }

        int[] pre = new int[a.length];
        for (int i = 1; i < a.length; i++) {
            pre[i] = pre[i - 1] + d[i];
        }
        int min = pre[1];
        for (int i = 2; i < a.length; i++) {
            min = Math.min(min, pre[i]);
        }
        System.out.println(min);

    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        long[] pre = new long[m + 1];
        Map<Long, Integer> exist = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            pre[i] = pre[i - 1] + i;
            exist.put(pre[i], i);
        }
        for (int i = 0; i < m - 1; i++) {
            if (exist.containsKey(pre[i] + m)) {
                System.out.println((i + 1) + " " + exist.get(pre[i] + m));
            }
        }
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        long M = sc.nextLong();
        long[] chM = new long[(int) (M + 1)];
        // 先把所有的和给存好
        for (int i = 1; i < chM.length; i++) {
            chM[i] += chM[i - 1] + i;
        }
        long j = 0;
        // 找到右边的下标
        for (int i = 0; i < chM.length; i++) {
            if (chM[i] >= M) {
                j = i;
                break;
            }
        }
        // 从左边开始遍历，如果说右边减左边是等于这个 M 的，说明就是这个区间，直接输出 i，j
        while (j < chM.length - 1){
            for (long i = 1; i < j; i++) {
                if (chM[(int) j] - chM[(int) i] == M) {
                    System.out.println((i + 1) + " " + j);
                    break;
                }
                // 如果说比他小了，那就是找不到了，那也直接退出
                if (chM[(int) j] - chM[(int) i] < M) {
                    break;
                }
            }
            j++;
        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 边界情况处理
        if (n <= 1) {
            System.out.println(0);
            return;
        }

        if (k < 0 || k >= n) {
            System.out.println("Invalid input");
            return;
        }
        // 先把每一段的时间是多少给存好
        long[] time = new long[n];
        for (int i = 1; i < n; i++) {
            time[i] = sc.nextLong();
            time[i] += time[i - 1];
        }
        // 找到最大的时间段
        long maxReduction = 0;
        long totalTime = time[time.length - 1];
        for (int i = 0; i < n - k; i++) {
            maxReduction = Math.max(maxReduction, (time[i + k] - time[i]));
        }
        System.out.println(totalTime - maxReduction);
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        // 先把每一段的时间是多少给存好
        int[] shiJian = new int[n - 1];
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            shiJian[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            max += shiJian[i];
        }
        // 找出最大的时间
        for (int i = 0, j = k; j < shiJian.length; i++, j++) {
            if (max < jiSuanShiJian(i, j, shiJian)) {
                max = jiSuanShiJian(i, j, shiJian);
            }
        }
        // 总共的时间减去最大的时间就行了
        int num = 0;
        for (int i = 0; i < shiJian.length; i++) {
            num += shiJian[i];
        }
        num -= max;
        System.out.println(num);
    }
    public static int jiSuanShiJian(int n, int k, int[] shiJian) {
        int ret = 0;
        // 先计算出到 k 的距离
        for (int l = 0; l < k; l++) {
            ret += shiJian[l];
        }
        for (int m = 0; m < n; m++) {
            ret -= shiJian[m];
        }
        return ret;
    }


    public static void main4(String[] args) {
        Main main = new Main();
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        if (A == 0) {
            System.out.println("No!!!");
            return;
        }
        int a = 123;
        int b = a * B / A;
        int c = a * C / A;
        for (a = 123; c < 1000; a++) {
            b = a * B / A;
            c = a * C / A;
            if (main.panDuan(a, b) && (main.panDuan(a, b, c))){
                System.out.println(a + " " + b + " " + c);
                flag = true;
            }

        }
        if (!flag) {
            System.out.println("No!!!");
        }

    }
    public boolean biJiao(int[] chA, int[] chB) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (chA[i] == chB[j]) {
                    return false;
                }
            }
        }
        if (chA[0] == chA[1] || chA[0] == chA[2] || chA[1] == chA[2]) {
            return false;
        }
        if (chB[0] == chB[1] || chB[0] == chB[2] || chB[1] == chB[2]) {
            return false;
        }
        if (chA[0] == 0 || chA[1] == 0 || chA[2] == 0 || chB[0] == 0 || chB[1] == 0 || chB[2] == 0) {
            return false;
        }
        return true;
    }
    public boolean panDuan(int A, int B) {
        int numA = A;
        int numB = B;
        int[] chA = new int[3];
        int[] chB = new int[3];
        for (int i = 0; i < 3; i++) {
            chA[i] = numA % 10;
            numA /= 10;
        }
        for (int i = 0; i < 3; i++) {
            chB[i] = numB % 10;
            numB /= 10;
        }
        return biJiao(chA, chB);
    }
    public boolean panDuan(int A, int B, int C) {
        return panDuan(A, B) && panDuan(A, C) && panDuan(B, C);
    }

    public static void main3(String[] args) {
        // 小写转大写
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        System.out.println(Character.toUpperCase(ch));
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sc.nextInt() * sc.nextInt());
    }

    public static void main1(String[] args) {
        int i = 0;
        while (i < 3) {
            int x = 1 + (2 * i);
            int k = (5 - x) / 2;
            // 先打印空格
            while (k-- > 0) {
                System.out.print(" ");
            }
            // 再打印星号
            while (x-- > 0) {
                System.out.print("*");
            }
            System.out.println();
            i++;
        }
        i-=1;
        while (i > 0) {
            int x = (2 * i) - 1;
            int k = (5 - x) / 2;
            // 先打印空格
            while (k-- > 0) {
                System.out.print(" ");
            }
            // 再打印星号
            while (x-- > 0) {
                System.out.print("*");
            }
            System.out.println();
            i--;
        }
    }
}*/
