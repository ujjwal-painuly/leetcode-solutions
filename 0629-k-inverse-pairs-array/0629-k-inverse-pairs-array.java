class Solution {
       static int mod = 1_000_000_007;
    public int kInversePairs(int n, int z) {
        int[][] dp=new int[n+1][z+1];
          dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=z;j++){
         long res=0;
            for(int k=0;k<= Math.min(j, i-1);k++){
            res=(res+dp[i-1][j-k])%mod;
            }
            dp[i][j]=(int)res;
            }

        }
        return dp[n][z];
    }
}