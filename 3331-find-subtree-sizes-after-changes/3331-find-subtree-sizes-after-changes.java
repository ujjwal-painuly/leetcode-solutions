
import java.util.*;

class Solution {

    public class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    int dfs(ArrayList<Edge> graph[], String s, int cur,
            int[] arr, boolean[] visit, int[] count) {

        visit[cur] = true;
        count[cur] = 1;

        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            if (!visit[e.dest]) {
                count[cur] += dfs(graph, s, e.dest, arr, visit, count);
            }
        }

        return count[cur];
    }

    void dfs2(ArrayList<Edge> graph[], int[] p, String s,
              int cur, int[] arr, boolean[] visit, int[] count) {

        visit[cur] = true;

        int ch = s.charAt(cur) - 'a';

        int near = arr[ch];

      if (near != -1) {
            p[cur] = near;
      }

        arr[ch] = cur;

        for (int i = 0; i < graph[cur].size(); i++) {
            Edge e = graph[cur].get(i);

            if (!visit[e.dest]) {
                dfs2(graph, p, s, e.dest, arr, visit, count);
            }
        }

        arr[ch] = near;
    }

    public int[] findSubtreeSizes(int[] p, String s) {

        int n = p.length;

        ArrayList<Edge> graph[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Original tree
        for (int i = 1; i < n; i++) {
            int u = p[i];
            int v = i;

            graph[u].add(new Edge(u, v));
        }

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        boolean[] visit = new boolean[n];

        int[] count = new int[n];

        // Find nearest same character ancestor
        dfs2(graph, p, s, 0, arr, visit, count);

        // Build modified tree
        ArrayList<Edge> graph2[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph2[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            graph2[p[i]].add(new Edge(p[i], i));
        }

        // Reset visited
        Arrays.fill(visit, false);
        Arrays.fill(count, 0);

        // Calculate subtree sizes
        dfs(graph2, s, 0, arr, visit, count);

        return count;
    }
}
