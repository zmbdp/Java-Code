import java.util.Map;
import java.util.TreeMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], (map.getOrDefault(nums[i], 0)+1));
        }
        int a = -1;
        int b = -1;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) >= 2) {
                if (a == -1) {
                    a = i;
                }
                else if (nums[i] == nums[a]){
                    if (i - a > k) {
                        i = a + 1;
                        a = -1;
                    }
                    else {
                        b = i;
                        break;
                    }
                }
            }
        }
        if (b - a <= k) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,2,3,1,2,3};
        solution.containsNearbyDuplicate(arr, 2);
    }
}