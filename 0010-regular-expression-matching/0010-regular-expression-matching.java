class Solution {
   int  helper(String s,String p,int i,int j,int[][] dp){
        if(s.length()==i  &&  p.length()==j){
            return 1;
        }
        if(i==s.length()){
           for(int k=j;k<p.length();k++){
           char ch=p.charAt(k);
           if( p.charAt(k)=='*'){
            continue;
           }
         else  if(((ch>='a'  &&  ch<='z') || ch=='.') &&  k+1<p.length()  && p.charAt(k+1)=='*'  ){
                  continue;
           }
           else {
            return 0;
           }
           }
           return 1;
        }
        if(j==p.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(s.charAt(i)==p.charAt(j)){
         if(j+1<p.length() && p.charAt(j+1)=='*'){
         if(helper(s,p,i,j+2,dp)==1 || helper(s,p,i+1,j,dp)==1  || helper(s,p,i+1,j+1,dp)==1 ){
             return dp[i][j]=1;
         }
     }
     else if(helper(s,p,i+1,j+1,dp)==1){
        return dp[i][j]=1;
    }
        }

      else  if(p.charAt(j)=='.'){
            if(helper(s,p,i+1,j+1,dp)==1){
                return dp[i][j]=1;
            }
        }
     
        else if(p.charAt(j)=='*'){

           if(p.charAt(j-1)==s.charAt(i)){
            if(helper(s,p,i+1,j,dp)==1 ||   helper(s,p,i,j+1,dp) ==1||  helper(s,p,i+1,j+1,dp) ==1){
              
                      return dp[i][j]=1;
                 } 
            }
           
           else if(p.charAt(j-1)=='.'){
                 if(helper(s,p,i+1,j,dp)==1  ||   helper(s,p,i,j+1,dp)==1 ||  helper(s,p,i+1,j+1,dp)==1){
               
                     return dp[i][j]=1;
                 
            } 
           }
         
           

        }
         if(s.charAt(i)!=p.charAt(j)){
             if(j+1<p.length()   &&  p.charAt(j+1)=='*'){
                 if(helper(s,p,i,j+2,dp)==1){
               
                     return dp[i][j]=1;
                 
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
      int ans=helper(s,p,0,0,dp);
      if(ans==1){
        return true;
      }
      return false;
    }
}