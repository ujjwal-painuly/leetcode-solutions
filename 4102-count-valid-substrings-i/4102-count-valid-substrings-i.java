class Solution {
    public long countValidSubstrings(String s) {

        int n = s.length();

        long res = 0;
        int lastb = 0;

        for (int i = 1; i < n - 1; i++) {

            if (s.substring(i - 1, i + 2).equals("abc")) {

                res += ((long)(i - lastb + 1) * (i - lastb + 2)) / 2 - 1;

                lastb = i;
            }
        }

        return res + ((long)(n - lastb) * (n - lastb + 1)) / 2;
    }
}