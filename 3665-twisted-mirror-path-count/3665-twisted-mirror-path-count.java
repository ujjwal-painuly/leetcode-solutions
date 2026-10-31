class Solution {
    static final long MOD = 1_000_000_007L;
    long solve(int[][] nums,int i,int j,int turn,long[][][] dp){
        if(i==nums.length-1 &&  j==nums[0].length-1){
            return 1;
        }
       if(i>=nums.length ||  j>=nums[0].length){
        return 0;
       }
       if(dp[i][j][turn]!=-1){
        return dp[i][j][turn];
       }
     
            if(nums[i][j]==0 ||  turn==0){
     long    right=0L;
                long down=0L;
            if(j+1<nums[0].length)   {  
     right=solve(nums,i,j+1,1,dp);
            }
            if(i+1<nums.length){
         down=solve(nums,i+1,j,2,dp);
            }
      return  dp[i][j][turn]= (down + right) % MOD;
            }else{
                if(turn==1){
       long    down=solve(nums,i+1,j,2,dp);
                return dp[i][j][turn]=down;
                }else{
                     long right=solve(nums,i,j+1,1,dp);
                     return dp[i][j][turn]= right;
                }
             
            }
      

    }
    public int uniquePaths(int[][] nums) {
        long[][][] dp=new long[nums.length][nums[0].length][3];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                Arrays.fill(dp[i][j],-1L);
            }
        }
        long ans= solve(nums,0,0,0,dp);
        
        return (int)ans;
    }
}