import java.util.Scanner;

public class A {
    /*public static void main(String[] args) {
        long mod =  (long) 1e9;
        long sum = 0;
        long ret = 1;
        for (long i = 1; i <= 40; i++) {
            ret = (ret *= i) % mod;// 计算出每个的阶层，只存储九位数字
            sum += ret;// 把前面的后九位全加起来
            sum %= mod;// 如果加起来的数值大于九位，就继续存储后九位
            System.out.println(sum);
        }
    }*/



    public static boolean haSaDe(int n) {
        boolean ret = true;
        int num = n;// 临时改变的数字
        int sum = 0;// 所有位数加起来的和
        // 先写十进制判断
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (n % sum != 0) {
            ret = false;
        }

        // 再转换成二进制
        num = n;// 临时改变的数字
        sum = 0;// 所有位数加起来的和
        // 先写十进制判断
        while (num > 0) {
            sum += num % 2;
            num /= 2;
        }
        if (n % sum != 0) {
            ret = false;
        }

            
        // 再转换成八进制
        num = n;// 临时改变的数字
        sum = 0;// 所有位数加起来的和
        // 先写十进制判断
        while (num > 0) {
            sum += num % 8;
            num /= 8;
        }
        if (n % sum != 0) {
            ret = false;
        }


        // 再转换成十六进制
        sum = 0;// 所有位数加起来的和
        num = n;// 临时改变的数字
        // 先写十进制判断
        while (num > 0) {
            sum += num % 16;
            num /= 16;
        }
        if (n % sum != 0) {
            ret = false;
        }


        return ret;
    }

    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0;// 第几个哈沙数
        int haSa = 1;// 表示哈沙数的具体值
        int Max = sc.nextInt();
        while (i < Max) {// 到了第 n 个数就得出来
            if (haSaDe(haSa)) {
                i++;
            }
            // 只有比这个小了，才能加加，不然就会大一
            if (i == Max) {
                System.out.println(haSa);
            }
            // 不管是不是哈沙数，都得++
            haSa++;
        }
    }*/


    /**
     * 思想：
     * 先计算出奇、偶数的个数，
     * 只有在奇数的个数是偶数个的时候
     * 才能满足S1 and S2全是偶数
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();// 表示有t组数据
        int N = sc.nextInt();// 表示数组A的长度
        int jiShu = 0;
        int ouShu = 0;
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < N; j++) {
                int x = sc.nextInt();
                if (x % 2 != 0) {
                    jiShu++;
                }
                else {
                    ouShu++;
                }
            }
        }
        // 奇数个数是偶数个
        if (jiShu % 2 == 0) {
            System.err.println((((int)Math.pow(2, (jiShu - 1)) * (int) Math.pow(2, ouShu)) % (1e9 + 7)));
        }
        else {
            System.out.println(0);
        }

    }
}








































