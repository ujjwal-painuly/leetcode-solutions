class Solution {
    public int numSub(String s) {
        long res = 0;
        int left = 0;
        long ans = 0;
        int MOD = 1000000007;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res += i - left + 1;
            } else {
                ans = (ans + res) % MOD;
                res = 0;
                left = i + 1;
            }
        }

        return (int)((ans + res) % MOD);
    }
}