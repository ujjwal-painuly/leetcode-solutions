class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
      int n=nums.length;
      int size=n-k+1;
  Deque<Integer> dq = new ArrayDeque<>();
      int[] ans=new int[size];
      int i=0;
      int j=0;
     while(j<n){
      if(!dq.isEmpty() && dq.peekFirst() < i) {
            dq.pollFirst();
            }
    while(!dq.isEmpty()  &&  nums[dq.peekLast()]<=nums[j]){
         dq.pollLast();
    }
    dq.addLast(j);
    
      if(j-i+1==k){
           ans[i] = nums[dq.peekFirst()];
           i++;
         }

     
       
        j++;

     }
       return ans;
      
    }
}