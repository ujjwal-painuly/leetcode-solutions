import java.util.*;

class Solution {

   int helper(int[] nums, int start, int target) {

    int low = start;
    int high = nums.length - 1;
    int ans = -1;

    while (low <= high) {

        int mid = low + (high - low) / 2;

        if (nums[mid] >= target) {

            if (nums[mid] == target) {
                ans = mid;
            }

            high = mid - 1;

        } else {
            low = mid + 1;
        }
    }

    return ans;
}

    int solve(int[] nums, int i, int inc, int[][] dp) {

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i][inc] != -1) {
            return dp[i][inc];
        }

        int count = 1;

        int curval = nums[i] + inc;

        int find = helper(nums, i + 1, curval + 1);

        if (find != -1) {
            count = Math.max(1 + solve(nums, find, 0, dp), count);
        }

        int find2 = helper(nums, i + 1, curval);

        if (find2 != -1) {
            count = Math.max(1 + solve(nums, find2, 1, dp), count);
        }

        return dp[i][inc] = count;
    }

    public int maxSelectedElements(int[] nums) {

        int n = nums.length;

        Arrays.sort(nums);

        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            ans = Math.max(ans, solve(nums, i, 0, dp));

            ans = Math.max(ans, solve(nums, i, 1, dp));
        }

        return ans;
    }
}