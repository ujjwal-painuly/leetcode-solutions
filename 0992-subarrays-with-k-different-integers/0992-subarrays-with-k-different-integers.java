class Solution {
    public int atMost(int[] nums,int k){
        if(k < 0) return 0;
          HashMap<Integer, Integer> map = new HashMap<>();

      int n=nums.length;
      int i=0;
      int count=0;
      int j=0;
      while(j<n){
        if(!map.containsKey(nums[j])){
            map.put(nums[j],1);
        }else{
            map.put(nums[j],map.get(nums[j])+1);
        }
         

         while(map.size()>k){
         map.put(nums[i],map.get(nums[i])-1);
         if(map.get(nums[i])==0){
            map.remove(nums[i]);
         }
         i++;
         }if(map.size()<=k){
            
            count+=j-i+1;
             j++;  
         }
         

      }
      return count;
     }  
        public int subarraysWithKDistinct(int[] nums, int k) {
  
     
     int count1 = atMost(nums, k); 
     int count2 = atMost(nums, k-1);

return count1 - count2;
    }
}