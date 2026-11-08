class Solution {
    public long countValidSubstrings(String s) {
        int n=s.length();
        int left=0;
        int right=0;
        long count=0;
        while(right<n){
           
            if(right>=2){
            if(s.charAt(right)=='c'  &&   s.charAt(right-1)=='b'  &&   s.charAt(right-2)=='a'){
            //  if(left<right-1){
                 left=right-1;
          //  }else{
             //    left=left;
           // }
            }
             

               
          
        }
               count+=right-left+1;
               right++;
        }
        
         return count;
        
    }
}