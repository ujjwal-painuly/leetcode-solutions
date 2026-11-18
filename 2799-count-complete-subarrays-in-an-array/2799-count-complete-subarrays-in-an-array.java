class Solution {
    public int countCompleteSubarrays(int[] nums) {

        HashMap<Integer, Integer> map1 = new HashMap<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (!map1.containsKey(nums[i])) {
                map1.put(nums[i], 1);
            }
        }

        int k = map1.size();

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {

            if (!map.containsKey(nums[j])) {
                map.put(nums[j], 1);
            } else {
                map.put(nums[j], map.get(nums[j]) + 1);
            }

            while (map.size() == k) {

                count += n - j;

                map.put(nums[i], map.get(nums[i]) - 1);

                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        return count;
    }
}