import java.util.*;

class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        int max = nums[nums.length - 1];

        int[] dp = new int[max + 3];

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            // Current element ko +1 karna
            dp[x + 1] = dp[x] + 1;

            // Current element ko as it is rakhna
            dp[x] = dp[x - 1] + 1;

            // Maximum answer update
            ans = Math.max(ans, Math.max(dp[x], dp[x + 1]));
        }

        return ans;
    }
}