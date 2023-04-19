import com.sun.jmx.snmp.internal.SnmpAccessControlModel;

import java.util.Arrays;

public class gaoBo {
    //寻找两个单身狗
    public static int[] even(int arr[]) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret ^= arr[i];
        }
        int count = 0;
        while ((ret & 1) != 1) {
            ret = ret >> 1;
            count++;
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (((arr[i] >> count) & 1) == 0) {
                x ^= arr[i];
            }
            else {
                y ^= arr[i];
            }
        }
        int drr[] = {x, y};
        return drr;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 2, 1};
        int ret[] = new int[2];
        ret = even(arr);
        System.out.println(Arrays.toString(ret));
    }



    //打印数组
    public static void main1(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 5, 6, 7}};
        //int arr[][] = new int[2][3];

        //第一种打印方式
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("————————————————————————————————————————");
        //第二种打印方式
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("————————————————————————————————————————");
        //第三种打印方式
        for (int brr[] : arr) {//先找到每一行的数组名
            for (int x: brr) {//再在每一行的数组里面找二维数组的值
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println("————————————————————————————————————————");
        //第四种打印方式
        System.out.println(Arrays.deepToString(arr));//深度打印
    }
}
