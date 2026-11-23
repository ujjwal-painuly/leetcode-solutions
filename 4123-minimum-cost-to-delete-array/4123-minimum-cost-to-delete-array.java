class Solution {
    public long minCost(int[] nums) {
        boolean flag = false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {       
                flag = true;
            }
        }
        long cost = 0;                
        if (flag == false) {
            long first = nums[0];
            long last = nums[n - 1];
            cost = first + last;
        } else {
            int count = 0;
            long z = 0;                
            long posmin = Long.MAX_VALUE;   
            long negmax = Long.MIN_VALUE;    
            for (int i = 1; i < n - 1; i++) {
                if (nums[i] < 0) {
                    z += nums[i];
                    negmax = Math.max(negmax, nums[i]);   
                    count++;
                } else {
                    posmin = Math.min(posmin, nums[i]);  
                }
            }
            if (count % 2 == 0) {
                cost = (long) nums[0] + nums[n - 1] + z;
                return cost;
            } else {
                cost = (long) nums[0] + nums[n - 1] + z;
                // option 1: sabse chhota |negative| chhod do
                long best = cost - negmax;
                // option 2: ek non-negative add kar do (agar hai)
                if (posmin != Long.MAX_VALUE) {
                    best = Math.min(best, cost + posmin);
                }
                return best;
            }
        }
        return cost;
    }
}