class Solution {
     int cost(String s,int i,int j,int[][] cost){
         int length=j-i+1;
         int min=Integer.MAX_VALUE;
         if(length == 1) {
    return 0;
}
if(cost[i][j]!=-1){
    return cost[i][j];
}
      
        for(int d=1;d<length;d++){
             
                  if (length % d != 0) continue;
                      int c=0;
          for(int start=0;start<d;start++){
         
             if(d>=1  &&  length%d==0  &&   d<length){
              int l =i+start;
              int r= l+(length/d-1)*d;
              while(l<r){
                if(s.charAt(l)!=s.charAt(r)){
                    c++;
                   
                }
                   l=l+d;
                    r=r-d;
                
              }
             }
          
            
          }
           min=Math.min(min,c);
        } 
         

         return cost[i][j]= min;

     }

   

    int solve(String s,int k,int start,int[][] cost,int[][] dp){
         
 if (k == 0) {
    if (start == s.length()) {
        return 0;
    }
    return Integer.MAX_VALUE;
}

if (start == s.length()) {
    return Integer.MAX_VALUE;
}
  if(dp[start][k]!=-1){
          return dp[start][k];
          }
    int min=Integer.MAX_VALUE;
      for(int i=start+1;i<s.length();i++){
     

         int cur=cost(s,start,i,cost);
            if(cur==Integer.MAX_VALUE){
             continue;
            }
         int ujjwal=solve(s,k-1,i+1,cost,dp);
           if(ujjwal==Integer.MAX_VALUE){
           continue;
         }
         int rem=ujjwal+cur;
         min=Math.min(min,rem);  
         }
        
      return  dp[start][k]=min;   
          
    }
    public int minimumChanges(String s, int k) {
        int[][] cost=new int[s.length()][s.length()];
         int[][] dp=new int[s.length()][k+1];
         for(int i=0;i<s.length();i++){
         Arrays.fill(dp[i],-1);
         }
           for(int i=0;i<s.length();i++){
         Arrays.fill(cost[i],-1);
         }
        return solve(s,k,0,cost,dp);
    }
}