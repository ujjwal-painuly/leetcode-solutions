class Solution {
    public boolean canAliceWin(int n) {
        int take=10;
        int step=0;
        while(take<=n){
            n-=take;
            step++;
            take--;
        }
        if(step%2!=0){
            return true;
        }else{
            return false;
        }
    }
}