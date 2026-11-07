import java.util.Arrays;

public class Problem04 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        boolean[] inTree = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int cost = 0;
        for (int iter = 0; iter < n; iter++) {
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!inTree[i] && (u == -1 || dist[i] < dist[u])) u = i;
            }
            inTree[u] = true;
            cost += dist[u];
            for (int v = 0; v < n; v++) {
                if (!inTree[v]) {
                    int w = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if (w < dist[v]) dist[v] = w;
                }
            }
        }
        return cost;
    }
}
