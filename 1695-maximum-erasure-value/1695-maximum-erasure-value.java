class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n=nums.length;
         HashMap<Integer,Integer> map=new HashMap<>();
         int ans=0;
         int i=0;
         int j=0;
         int count=0;
         while(j<n){
          if(!map.containsKey(nums[j])){
              map.put(nums[j],1);
          
              count+=nums[j];
                  j++;
               ans=Math.max(ans,count);
            }else {
               
         while(map.containsKey(nums[j])){
                if(i<n){
                count-=nums[i];
                map.remove(nums[i]);
                
             
             
                    ans=Math.max(ans,count);
              i++;
              
                }
         }
          map.put(nums[j],1);
                  count+=nums[j];
                 j++;
            }
           

         }
         
         return ans;
        
        
    }
}