public class Solution1 {
    public static int minCostClimbingStairs(int[] cost) {
        // 核心思想：
        // 根据 前一个最小的值加上cost[i] 和 前两个最小的值加上cost[i - 1] 找最小
        // 直接放到 dp[i] 中，然后 dp[i] 就是最小值，循环迭代往后走
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i - 1]);
        }
        return dp[cost.length - 1];
    }

    public static void main(String[] args) {
        //System.out.println(Solution1.minCostClimbingStairs(new int[]{10, 15, 20}));
        String arr  ="1231232431";
        char[] a = arr.toCharArray();

        System.out.println(a);
    }
}