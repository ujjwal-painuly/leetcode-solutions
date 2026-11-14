class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                
                if(j-i+1>=l  &&  j-i+1<=r){
                      int sum=0;
                   int first=i;
                   int second=j;
                 
                   for(int k=first;k<=second;k++){
                      sum+=nums.get(k);
                   }
                        if(sum>0){
                     ans=Math.min(ans,sum);
                       }
                }
              
            }
        }
        if(ans==Integer.MAX_VALUE){
            return -1;
        }else{
           return  ans;
        }
    }
}