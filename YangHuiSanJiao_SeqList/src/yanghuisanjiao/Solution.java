package yanghuisanjiao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rets = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        int hang = 0;
        int lie = 0;
        ret.add(1);
        rets.add(ret);
        for(hang = 1; hang < numRows; hang++)
        {
            // 一行一行弄，弄完一行就刑，一共有numRows行

            // 每一行第一个一定是1
            List<Integer> list = new ArrayList<>();
            list.add(1);

            // 每一行中间的数字
            for(lie = 1; lie < hang; lie++)
            {
                int a = rets.get(hang - 1).get(lie) + rets.get(hang - 1).get(lie - 1);
                list.add(a);
            }
            //rets.add(list);

            // 每一行最后的数字也一定是1
            list.add(1);
            rets.add(list);
        }
        return rets;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请问你想输出几行->?");
        int n = sc.nextInt();

        List<List<Integer>> lists = generate(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                //打印空格
                System.out.print(" ");
            }
            System.out.println(lists.get(i));
        }
    }
}