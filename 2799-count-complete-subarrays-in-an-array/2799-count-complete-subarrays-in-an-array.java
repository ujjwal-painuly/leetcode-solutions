class Solution {
    public int countCompleteSubarrays(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            set.add(x);
        }

        int k = set.size();
        int n = nums.length;
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

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