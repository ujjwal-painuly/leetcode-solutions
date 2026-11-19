class Solution {
    int solve(int[] nums,int k){
        int count=0;
    int n=nums.length;
      int i=0;
      int j=0;
      int odd=0;
      while(j<n){
          if(nums[j]%2!=0){
            odd++;
          }   

          while(odd>k){
              if(nums[i]%2!=0){
                odd--;
              }
            i++;
          }
            if(odd<=k){

            count+=j-i+1;
           

          }
         j++;
      }  

  return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
      int n=nums.length;
      int count=solve(nums,k);
      int count2=solve(nums,k-1);

      return count-count2;
    }
}