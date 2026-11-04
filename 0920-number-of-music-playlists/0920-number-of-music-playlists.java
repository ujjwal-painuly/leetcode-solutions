class Solution {
 int mod = 1_000_000_007;
    int solve(int n,int goal,int k,int idx,int used,int[][] dp){
        if(idx==goal){
          if(used==n){
            return 1;
          }else if(used!=n){
            return 0;
          }

        }
        if(used>n){
            return 0;
        }
          if(dp[idx][used]!=-1){
            return  dp[idx][used];
          }
         int ans=0;
         int rem=n-used;
         int z=used-k;
         long a=0;
        // if(used<n){
      a=(long)rem*solve(n,goal,k,idx+1,used+1,dp)%mod;
        // }
     long  b=0;
         if(used>k){
        b=(long)z*solve(n,goal,k,idx+1,used,dp)%mod;
         }
       
    ans = (int)((a+b)%mod);
       dp[idx][used]=  ans;
       return ans;

         
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        int[][] dp=new int[goal+1][n+1];
        for(int i=0;i<=goal;i++){
            Arrays.fill(dp[i],-1);
        }
         return solve(n,goal,k,0,0,dp);
    }
}