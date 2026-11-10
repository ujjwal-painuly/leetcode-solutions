class Solution {
    int solve(int n,int[] nums,int i,int[] dp){
        if(i==n){
            return 0;

        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int next=Integer.MAX_VALUE;
        for(int j=i+1;j<=i+3 && j<=n;j++){
           
            next=Math.min(next,nums[j-1]+((j-i)*(j-i))+solve(n,nums,j,dp));
            
        }
     return dp[i]=next;
         
    }            
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
      return solve(n,costs,0,dp); 
    }
}




