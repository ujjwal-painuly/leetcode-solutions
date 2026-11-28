class Solution {
    public int maxSelectedElements(int[] nums) {

        Arrays.sort(nums);

        HashMap<Integer, Integer> dp = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {

            int x = nums[i];

            // Current element ko x+1 banana
            if (dp.containsKey(x)) {
                dp.put(x + 1, dp.get(x) + 1);
            } else {
                dp.put(x + 1, 1);
            }

            // Current element ko as it is rakhna
            if (dp.containsKey(x - 1)) {
                dp.put(x, dp.get(x - 1) + 1);
            } else {
                dp.put(x, 1);
            }

            // Answer update
            ans = Math.max(ans, dp.get(x));
            ans = Math.max(ans, dp.get(x + 1));
        }

        return ans;
    }
}