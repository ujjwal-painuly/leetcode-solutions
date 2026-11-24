class Solution {
    public class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }

    public class pair implements Comparable<pair>{
        int node;
        long dis;
        public pair(int node,long dis){
            this.node=node;
            this.dis=dis;
        }
        @Override
        public int compareTo(pair p2){
            return Long.compare(this.dis,p2.dis);
        }
    }

    public long[] earliestActivationTimes(int n, int[][] edges, int[] requiredSignals) {
        long[] ans=new long[n];
        Arrays.fill(ans,-1);
        ArrayList<Edge> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        int[] count=new int[n];

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int z=edges[i][2];
            graph[u].add(new Edge(u,v,z));// directed graph
        }

        ans[0]=0;
        boolean[] visit=new boolean[n];
        visit[0]=true;
        PriorityQueue<pair> pq=new PriorityQueue<>();

        for(Edge e: graph[0]){
            pq.add(new pair(e.dest, e.wt));
        }

        while(!pq.isEmpty()){
            pair cur=pq.remove();
            int v=cur.node;
            long time=cur.dis;

            if(visit[v]){
                continue;
            }

            count[v]+=1;
            if(count[v]==requiredSignals[v]){
                visit[v]=true;
                ans[v]=time;
                for(Edge e: graph[v]){
                    pq.add(new pair(e.dest, time+e.wt));
                }
            }
        }
        return ans;
    }
}