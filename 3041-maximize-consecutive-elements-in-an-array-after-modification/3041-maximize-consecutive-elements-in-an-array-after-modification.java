import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);

        int max = nums[nums.length - 1];
        // dp[v] = longest consecutive chain jo value v pe end hoti hai
        int[] dp = new int[max + 3];

        int ans = 0;

        for (int x : nums) {
            // pehle x+1 (increase karke), phir x (as it is)
            // order important hai: same x do baar aaye to dono ek hi element se use na ho
            dp[x + 1] = dp[x] + 1;
            dp[x] = dp[x - 1] + 1;

            ans = Math.max(ans, Math.max(dp[x], dp[x + 1]));
        }

        return ans;
    }
}