// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n=s.length();
//         int m=p.length();
//           boolean[][] dp=new boolean[s.length()+1][p.length()+1];
//           dp[0][0]=true;
//            for(int j=1;j<=m;j++){
//             if(p.charAt(j-1)=='*'){
//              dp[0][j]=dp[0][j-1];
//             }
//            }
//           for(int i=1;i<=n;i++){
//             for(int j=1;j<=m;j++){
//               if(s.charAt(i-1)==p.charAt(j-1)){
//                 dp[i][j]=dp[i-1][j-1];
//               }
//         else if(p.charAt(j-1)=='?'){
//             dp[i][j]=dp[i-1][j-1];
//             }

//         else{
//            if(p.charAt(j-1)=='*'){
          
//          dp[i][j] = dp[i][j-1] || dp[i-1][j];

//            }
           
//            }

//         }

//         }
            
          
//           return dp[n][m];
//     }
// }


class Solution {
   int helper(String s,String p,int i,int j,int[][] dp){
        if(i==s.length()  &&  j==p.length()){
            return 1;
        }
        
        if(j==p.length()){
         if(i==s.length()){
            return 1;
         }
         else{
            return 0;
         }
        }
        if(i==s.length()){
             if(j==p.length()){
            return 1;
         }
       
         else{
           for(int k=j;k<p.length();k++){
            char ch=p.charAt(k);
                 if((ch>='a'   &&   ch<='z') ||  ch=='?' ){
                    return 0;
                 }
                 else if(ch=='*'){
                    continue;
                 }
           }
           return 1;
         }
        
        }
         if(dp[i][j]!=-1){
            return dp[i][j];
         }
        if(s.charAt(i)==p.charAt(j)){
            if(helper(s,p,i+1,j+1,dp)==1){
            return   dp[i][j]=1;
            }
        }else if(p.charAt(j)=='?'){
             if(helper(s,p,i+1,j+1,dp)==1){
            return    dp[i][j]=1;
            }

        }else{
           if(p.charAt(j)=='*'){
              if((helper(s,p,i,j+1,dp) ==1 ||   helper(s,p,i+1,j,dp)==1 || helper(s,p,i+1,j+1,dp)==1)){
             return   dp[i][j]=1;
              }
           }
        }
        return dp[i][j]=0;

    }
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()][p.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
       int ans= helper(s,p,0,0,dp);
       if(ans==1){
        return true;
       }
       return false;
    }
}