class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {

        int n = servers.length;
        int m = tasks.length;

        PriorityQueue<int[]> freeServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<long[]> busyServers = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0])
                return Long.compare(a[0], b[0]);
            if (a[1] != b[1])
                return Long.compare(a[1], b[1]);
            return Long.compare(a[2], b[2]);
        });

        for (int i = 0; i < n; i++) {
            freeServers.offer(new int[]{servers[i], i});
        }

        int[] result = new int[m];

        long curtime = 0;

        for (int i = 0; i < m; i++) {

            curtime = Math.max(curtime, i);

            while (!busyServers.isEmpty() &&
                   busyServers.peek()[0] <= curtime) {

                long[] server = busyServers.poll();

                int wt = (int) server[1];
                int idx = (int) server[2];

                freeServers.offer(new int[]{wt, idx});
            }

            if (freeServers.isEmpty()) {

                curtime = busyServers.peek()[0];

                while (!busyServers.isEmpty() &&
                       busyServers.peek()[0] <= curtime) {

                    long[] server = busyServers.poll();

                    int wt = (int) server[1];
                    int idx = (int) server[2];

                    freeServers.offer(new int[]{wt, idx});
                }
            }

            int[] server = freeServers.poll();

            int wt = server[0];
            int idx = server[1];

            result[i] = idx;

            long finishTime = curtime + tasks[i];

            busyServers.offer(new long[]{
                finishTime, wt, idx
            });
        }

        return result;
    }
}