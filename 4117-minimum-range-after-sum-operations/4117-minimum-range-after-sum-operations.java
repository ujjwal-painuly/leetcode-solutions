class Solution {
    public int minRange(int a, int b, int c) {
      int ans=Integer.MAX_VALUE;

        int jyada=Math.max(a,Math.max(b,c));
        int kaam=Math.min(a,Math.min(b,c));
        ans=Math.min(ans,jyada-kaam);

        
        int x=b+c;
        int max=Math.max(x,Math.max(b,c));
        int min=Math.min(x,Math.min(b,c));
              
         ans=Math.min(ans,max-min);

        int y=a+c;
        max=Math.max(y,Math.max(a,c));
        min=Math.min(y,Math.min(a,c));
        ans=Math.min(ans,max-min);

        int z=a+b;
        max=Math.max(z,Math.max(a,b));
        min=Math.min(z,Math.min(a,b));
        ans=Math.min(ans,max-min);


        

        return ans;
    }
}