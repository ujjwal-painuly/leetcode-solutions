class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        // next strictly greater element
        int[] nge = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // op[i]: cost to lift [i, nge[i]-1] up to nums[i]
        // tot[i]: total cost along the whole chain starting at i
        long[] op = new long[n];
        long[] tot = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            int m = nge[i];
            op[i] = (long) nums[i] * (m - i) - (prefix[m] - prefix[i]);
            tot[i] = op[i] + tot[m];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        long ans = 0;

        for (int j = 0; j < n; j++) {

            // strict '<' -> front = FIRST occurrence of max
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }
            dq.addLast(j);

            while (i <= j) {

                while (dq.peekFirst() < i) {
                    dq.pollFirst();
                }

                int p = dq.peekFirst();

                long operation = tot[i] - tot[p]
                        + (long) nums[p] * (j - p + 1)
                        - (prefix[j + 1] - prefix[p]);

                if (operation <= k) break;

                i++;
            }

            ans += j - i + 1;
        }

        return ans;
    }
}