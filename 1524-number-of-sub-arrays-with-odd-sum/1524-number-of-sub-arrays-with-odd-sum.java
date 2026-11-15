class Solution {
    int mod = 1_000_000_007;
    public int numOfSubarrays(int[] nums) {
        int n=nums.length;
       long[] prefix=new long[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int count=0;
        int even=1;
        int odd=0;
        for(int i=0;i<n;i++){
       int  cur=(int)prefix[i];
           if(cur%2==0){  //2+1=3
          count = (int)((count + (long)odd) % mod);
             even++;      
           }else{
          count = (int)((count + (long)even) % mod);
            odd++;
           }

        
        }
        return count;
    }
}