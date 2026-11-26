class Solution {
    public boolean canAliceWin(int n) {
        double d = 441 - 8.0 * n;                 // discriminant (b² - 4ac), a=1, b=-21, c=2n
        int k = (int) Math.floor((21 - Math.sqrt(d)) / 2);  // max moves possible
        return k % 2 == 1;
    }
}