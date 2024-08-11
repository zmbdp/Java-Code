import java.sql.Array;
import java.util.Arrays;

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = nums.length - 1; i >= 2; i--){
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ret += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.triangleNumber(new int[] {12,34,12,4,76,0,34,6,12,0,45,12,5,47,24,16,0,4,145,7,1});
    }
}