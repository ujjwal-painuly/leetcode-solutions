class Solution {
    public boolean increasingTriplet(int[] nums) {
        int nums1=Integer.MAX_VALUE;
        int n=nums.length;
        int nums2=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
         int nums3=nums[i];
         if(nums1>=nums3){
            nums1= nums3;
         }else if(nums2>=nums3){
             nums2=nums3;
          
         }else{
            return true;
         }
        }
        return false;
    }
}