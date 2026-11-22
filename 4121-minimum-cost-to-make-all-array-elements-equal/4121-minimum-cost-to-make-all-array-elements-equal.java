class Solution {
    public long minCost(int[] nums) {
        int n=nums.length;
       long cost=Long.MAX_VALUE;
       int j;
         
        for(int i=1;i<n-1;){
             j=i+1;
              int z=0;
           while(j<n  &&  z<n   &&  nums[i]==nums[j]){
             j++;
             z++;
           }
          
          
             long next=(long)nums[i]*(n-j);
            
               j=i-1;
            while(j>=0  &&  nums[j]==nums[i]){
                j--;
            }
           long prev=(long)nums[i]*(j+1);


             cost=Math.min(cost,prev+next);

           i+=z+1;

        }
        return cost;
    }
}