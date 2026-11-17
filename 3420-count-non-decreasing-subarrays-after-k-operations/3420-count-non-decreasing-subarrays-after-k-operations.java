class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;
        Stack<Integer> st=new Stack<>();
        int[] nge=new int[n];
        for(int i = n - 1; i >= 0; i--) {

    while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
        st.pop();
    }

    if (st.isEmpty()) {
        nge[i] = n;
    } else {
        nge[i] = st.peek();
    }

    st.push(i);
}

      long[] prefix = new long[n];              // inclusive
prefix[0] = nums[0];
for (int i = 1; i < n; i++) {
    prefix[i] = prefix[i - 1] + nums[i];
}
        long[] op = new long[n + 1];  
        for (int i = n - 1; i >= 0; i--) {
            int m = nge[i];
            if(i!=0){
            op[i] = (long) nums[i] * (m-1 - i+1)
                    - (prefix[m-1] - prefix[i-1])
                    + op[m];
                    }else{
                         op[i] = (long) nums[i] * (m-1 - i+1)
                    - prefix[m-1]
                    + op[m];   
                    }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0, j = 0;
        long ans = 0;

        while (j < n) {

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[j]) {
                dq.pollLast();
            }
            dq.addLast(j);

          while (i <= j) {

    while (!dq.isEmpty() && dq.peekFirst() < i) {
        dq.pollFirst();
    }

    int m = dq.peekFirst();
    long operation;

    if (m > i) {
        operation = op[i] - op[m]
                + (long) nums[m] * (j - m + 1)
                - (prefix[j ] - prefix[m-1]);
    }  else {
                   
                    if (i != 0) {
                    operation = (long) nums[m] * (j - i + 1) - (prefix[j] - prefix[i - 1]);
                    } else {
                         operation = (long) nums[m] * (j - i + 1) - prefix[j];
                    }
                 
                }

    if (operation <= k) break;

    i++; 
}

            ans += j - i + 1;
            j++;
        }

        return ans;
    }
}