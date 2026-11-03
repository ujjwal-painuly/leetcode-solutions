class Solution {
       int mod = 1000000007;
    int solve(String s,int idx,int rank,int[][] dp){
        if(idx==s.length()){
            return 1;
        }
        if(dp[idx][rank]!=-1){
            return dp[idx][rank];
        }
           int ans=0;
              int remaning=s.length()-idx;
             if(s.charAt(idx)=='D'){
         for(int i=0;i<rank;i++){
           
            ans= (ans+solve(s,idx+1,i,dp))%mod;
         }

            }else {
             
                for(int i=rank;i<remaning;i++){
              ans= (ans+solve(s,idx+1,i,dp))%mod;
                }
            }
         
         return dp[idx][rank]= ans;
    }
    public int numPermsDISequence(String s) {
        int ans=0;
        int[][] dp=new int[s.length()+1][s.length()+1];
        for(int i=0;i<s.length()+1;i++){
            Arrays.fill(dp[i],-1);
        }

      for(int i=0;i<=s.length();i++){
         ans= (ans+solve(s,0,i,dp))%mod;
      }
      return ans;
    }
}