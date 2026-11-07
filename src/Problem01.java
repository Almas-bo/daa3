public class Problem01 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            count++;
            int[] stack = new int[n];
            int top = 0;
            stack[top++] = i;
            visited[i] = true;
            while (top > 0) {
                int u = stack[--top];
                for (int v = 0; v < n; v++) {
                    if (isConnected[u][v] == 1 && !visited[v]) {
                        visited[v] = true;
                        stack[top++] = v;
                    }
                }
            }
        }
        return count;
    }
}
