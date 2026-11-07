import java.util.Arrays;

public class Problem03 {
    private int[] parent;

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int m = n * (n - 1) / 2;
        int[][] edges = new int[m][3];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges[k][0] = w;
                edges[k][1] = i;
                edges[k][2] = j;
                k++;
            }
        }
        Arrays.sort(edges, (a, b) -> Integer.compare(a[0], b[0]));
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int cost = 0;
        int used = 0;
        for (int[] e : edges) {
            int a = find(e[1]);
            int b = find(e[2]);
            if (a != b) {
                parent[a] = b;
                cost += e[0];
                if (++used == n - 1) break;
            }
        }
        return cost;
    }
}
