
class Solution {
    public long maxKelements(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        long ans = 0;

        while(k > 0) {

            int x = pq.poll();

            ans = ans + x;

            pq.add((x + 2) / 3);

            k--;
        }

        return ans;
    }
}
