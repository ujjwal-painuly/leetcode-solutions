class Solution {

    long smallestPrimeFactor(long x) {

        if (x % 2 == 0) {
            return 2;
        }

        for (long i = 3; i <= x / i; i += 2) {
            if (x % i == 0) {
                return i;
            }
        }

        return x;
    }

    public long minimumMaxValue(int n, int index, int value) {

   

        if (value == 1 && n > 1) {
            return -1;
        }

        long p = smallestPrimeFactor(value);

        // LEFT SIDE
        if (index > 0) {
            long left = (long)value - p;
            left=left-2L*(index - 1);
            if (left <= 0) {
                return -1;
            }
        }

        // RIGHT SIDE
        long curr = value;

        if (index < n ) {

           curr = (long)value + p;

            curr =curr   +  2L * (n - index - 2);
        }

        return curr;
    }
}
