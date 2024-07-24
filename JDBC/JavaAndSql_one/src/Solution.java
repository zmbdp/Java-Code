class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 建立一个数组，存放美元面值
        int[] dl = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                dl[0]++;
            }
            if (bills[i] == 10) {
                dl[0]--;
                dl[1]++;
            }
            if (bills[i] == 20) {
                // 看看十块的有没有，有的话先拿十块，没有的话再说
                if (bills[1] >= 1) {
                    dl[1]--;
                    dl[0]--;
                }
                // 没有十块的话就直接减五块的
                else {
                    dl[0]-=3;
                }
                dl[2]++;
            }
            if (dl[0] < 0 || dl[1] < 0 || dl[2] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a = {5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        new Solution().lemonadeChange(a);
    }
}