
import java.util.*;

class Solution {

    TreeMap<Integer,Integer> left = new TreeMap<>();
    TreeMap<Integer,Integer> right = new TreeMap<>();

    int leftSize = 0, rightSize = 0;
    long leftSum = 0, rightSum = 0;

    void add(TreeMap<Integer,Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void remove(TreeMap<Integer,Integer> map, int val) {
        if(map.get(val) == 1) map.remove(val);
        else map.put(val, map.get(val) - 1);
    }

    void balance() {

        int target = (leftSize + rightSize + 1) / 2;

        while(leftSize > target) {

            int val = left.lastKey();

            remove(left, val);
            add(right, val);

            leftSize--;
            rightSize++;

            leftSum -= val;
            rightSum += val;
        }

        while(leftSize < target) {

            int val = right.firstKey();

            remove(right, val);
            add(left, val);

            rightSize--;
            leftSize++;

            rightSum -= val;
            leftSum += val;
        }
    }

    void insert(int val) {

        if(left.isEmpty() || val <= left.lastKey()) {
            add(left, val);
            leftSize++;
            leftSum += val;
        }
        else {
            add(right, val);
            rightSize++;
            rightSum += val;
        }

        balance();
    }

    void delete(int val) {

        if(left.containsKey(val)) {
            remove(left, val);
            leftSize--;
            leftSum -= val;
        }
        else {
            remove(right, val);
            rightSize--;
            rightSum -= val;
        }

        balance();
    }

    long getCost() {

        long median = left.lastKey();

        return median * leftSize - leftSum
             + rightSum - median * rightSize;
    }

    long solve(int[] nums, int x, int k, int idx,
               int count, long[] cost, long[][] dp) {

        if(count == k) return 0;

        if(idx >= cost.length)
            return Long.MAX_VALUE / 4;

        if(dp[idx][count] != -1)
            return dp[idx][count];

        long take = cost[idx] +
            solve(nums, x, k, idx + x, count + 1, cost, dp);

        long skip =
            solve(nums, x, k, idx + 1, count, cost, dp);

        return dp[idx][count] = Math.min(take, skip);
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        // Sliding Window
        for(int j = 0; j < n; j++) {

            insert(nums[j]);

            if(j >= x) {
                delete(nums[j - x]);
            }

            if(j >= x - 1) {
                cost[j - x + 1] = getCost();
            }
        }

        // DP
        long[][] dp = new long[cost.length + 1][k + 1];

        for(long[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, x, k, 0, 0, cost, dp);
    }
}
