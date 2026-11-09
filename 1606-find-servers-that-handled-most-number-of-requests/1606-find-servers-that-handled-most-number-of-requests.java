class Solution {
    public List<Integer> busiestServers(int k, int[] a, int[] load) {
       
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (x, y) -> Long.compare(x[0], y[0])
        );
         List<Integer> ujjwal=new ArrayList<>();

       TreeSet<Integer> set=new TreeSet<>();
       for(int i=0;i<k;i++){
        set.add(i);
       }
       int[] ans=new int[k];
       for(int i=0;i<a.length;i++){
               
            while (!busy.isEmpty() && busy.peek()[0] <= a[i]) {
                long[] s = busy.poll();
                
                  set.add((int)s[1]); 
            }
              int idx = i % k;

              if (set.isEmpty()) {
                continue;
            }
            Integer server = set.ceiling(idx);
       
            if (server == null) {
                server = set.first();
            }

         
            set.remove(server);

            ans[server]++;

            long finishTime = (long) a[i] + load[i];

            busy.offer(new long[]{finishTime, server});



            


       }
       int max=0;
       for(int i=0;i<k;i++){
          max=Math.max(ans[i],max);
       }
              for (int i = 0; i < k; i++) {
            if (ans[i] == max) {
                ujjwal.add(i);
            }
        }
        return ujjwal;


    }
}