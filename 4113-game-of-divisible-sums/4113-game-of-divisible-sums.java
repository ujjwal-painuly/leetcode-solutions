class Solution {
    long solve(int[] nums,int i,long[] dp){
      if(i>=nums.length){
          return 0;
      }
        if(dp[i]!=-1){
            return dp[i];
        }
       long sum=nums[i];
        long z=Long.MIN_VALUE;
        if(sum%3==0){
          z=sum-solve(nums,i+1,dp);   
        }else if(sum%3!=0){
            z=sum+solve(nums,i+1,dp);
        }
        long y=Long.MIN_VALUE;
        if(i+1<nums.length){
            long second=(long)nums[i]+nums[i+1];
            if(second%3==0){
            y=second-solve(nums,i+2,dp);
            }else{
                y=second+solve(nums,i+2,dp);
            }
        }
        return dp[i]= Math.max(y,z);
        
    
        
    }
    public long maxDifference(int[] nums) {
        long[] dp=new long[nums.length+1];
        Arrays.fill(dp,-1);
       return solve(nums,0,dp); 
    }
}