import java.util.*;

class Solution {

    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            // Current element ko x+1 banana
            dp.put(x + 1, dp.getOrDefault(x, 0) + 1);

            // Current element ko as it is rakhna
            dp.put(x, dp.getOrDefault(x - 1, 0) + 1);

            ans = Math.max(ans, dp.get(x));
            ans = Math.max(ans, dp.get(x + 1));
        }

        return ans;
    }
}