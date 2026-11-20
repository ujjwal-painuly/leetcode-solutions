class Solution {
    int solve(int[] nums,int k){
         int n=nums.length;
         if(k<0){
            return 0;
         }
        int i=0;
        int j=0;
        int sum=0;
        int ans=0;
        while(j<n){
          sum+=nums[j];
           
          while(sum>k &&  i<n){
            sum-=nums[i];
            i++;
          } 
           if(sum<=k){
           ans+=j-i+1;
          }  
          j++;  
        }

        return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
       int sum1=solve(nums,goal);
       int sum2=solve(nums,goal-1);
       return sum1-sum2;
    }
}