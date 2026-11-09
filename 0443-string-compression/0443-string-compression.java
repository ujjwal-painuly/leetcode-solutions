class Solution {
    public int compress(char[] c) {

        int idx = 0;
        int i = 0;

        while (i < c.length) {

            char ch = c[i];
            int count = 0;

            while (i < c.length && c[i] == ch) {
                count++;
                i++;
            }

            c[idx++] = ch;

            if (count > 1) {
                String s = "" + count;

                for (int j = 0; j < s.length(); j++) {
                    c[idx++] = s.charAt(j);
                }
            }
        }

        return idx;
    }
}