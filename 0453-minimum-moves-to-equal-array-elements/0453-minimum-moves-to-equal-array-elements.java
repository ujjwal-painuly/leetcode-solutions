class Solution {
    public int minMoves(int[] nums) {
      int n=nums.length;
      int count=0;
      int max=Integer.MAX_VALUE;
      for(int i=0;i<n;i++){
        max=Math.min(max,nums[i]);
      }
      for(int i=0;i<n;i++){
        count+=(nums[i]-max);
      }  
      return count;
  

    }
}