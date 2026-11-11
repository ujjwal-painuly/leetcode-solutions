class Solution {
    public long minimumCost(int cost1, int cost2, int totalcost, int need1, int need2) {
    long sum=cost1+cost2;
    long count=0;
      if(sum>totalcost){
           int min=Math.min(need1,need2);
         
            count+=(long)min*totalcost;
            need1-=min;
            need2-=min;

         
         if(need1>0){
    
         count+=(long) need1*Math.min(totalcost,cost1);
      
    
         } if(need2>0){
             
         count+=(long) need2*Math.min(totalcost,cost2);
       
     
         }


       
       
      
           
       return count;
             
            
      }else{
         if(need1>0){
            count+=(long)need1 * cost1;
            
         } if(need2>0){
               count+=(long)need2 * cost2;
         }
         return count;
      }

     

   
    } 
}

