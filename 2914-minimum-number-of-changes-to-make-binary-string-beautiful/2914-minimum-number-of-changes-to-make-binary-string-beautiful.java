class Solution {
    public int minChanges(String s) {
        int n=s.length();
        int count=0;
         if(n==2){
            int one=0;
            int zero=0;
            for(int i=0;i<n;i++){
             if(s.charAt(i)=='0'){
                zero++ ;
             }   if(s.charAt(i)=='1'){
               one++;
             } 
            }
             if(one>zero){
                count+=zero;
             }else{
                count+=one;
             }
             return count;
            }
         
        for(int i=0;i<n;i+=2){
            int j=i;
        int zero=0;
        int one=0;
            while(j<i+2){
            if(s.charAt(j)=='0'){
           zero++;
            }else{
                one++;
            }
           j++;
            }
             if(zero>one){
                count+=one;
            }else if(zero<one){
                count+=zero;
            }else{
                count+=one;
            }
          
        }
        return count;
    }
}