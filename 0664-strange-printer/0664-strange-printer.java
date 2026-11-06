class Solution {
    int solve(String s,int first,int last,int[][] dp){
        if(first==last){
            return 1;
        }
        if(first>last){
            return 0;
        }
         if(dp[first][last]!=-1){
            return dp[first][last];
         }
        int ans=Integer.MAX_VALUE;
        int ans1=0;
        int i=first;
    //    if(first+1<=last){
    //       i=first+1;
    //    }
        
        while(i<last  &&  s.charAt(first)==s.charAt(i)){
              i++;
        } 
       
        ans1=1+solve(s,i,last,dp);
     
        // greedy
        int ujjwal=Integer.MAX_VALUE;
        for(int j=i;j<=last;j++){
            if(s.charAt(first)==s.charAt(j)){
                ujjwal=Math.min(ujjwal,solve(s,i,j-1,dp)+solve(s,j,last,dp));  
            }
        }

         ans=Math.min(ans1,ujjwal);

        return  dp[first][last]=ans;

    }
    public int strangePrinter(String s) {
        int[][] dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);

        }
        return solve(s,0,s.length()-1,dp);
    }
}