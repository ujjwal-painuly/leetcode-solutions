class Solution {
    public long minCost(int[] nums) {
         int n=nums.length;
         long ans=Long.MAX_VALUE;
        int j;
        for(int i=0;i<n;i=j+1){
            j=i;
            while(j+1<n  &&  nums[j]==nums[j+1]){
                j++;
            }
            if(  i==0  &&  j==n-1){
                return 0;
            }
            int prev=Math.max(i,1);
            int next=Math.min(j,n-2);
            if(prev<=next){
              
             long x;
                long y;
                if(i==0){
                    x=0;
                }else{
                    x=i;
                }
                if(j==n-1){
                    y=0;
                }else{
                    y=n-1-j;
                }
                // yeha per ab
                long a=(x+y)*nums[i];
                ans=Math.min(ans,a);
            }
            
        }
        return ans;
        
    }
}