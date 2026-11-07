import java.util.ArrayList;
import java.util.List;

public class Problem06 {
    public int countDependencyGroups(int n, int[][] dependencies) {
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] d : dependencies) g[d[0]].add(d[1]);

        int[] tin = new int[n];
        int[] low = new int[n];
        boolean[] onStack = new boolean[n];
        int[] idx = new int[n];
        int[] callStack = new int[n];
        int[] sccStack = new int[n];
        int sp = 0;
        int timer = 0;
        int count = 0;

        for (int s = 0; s < n; s++) {
            if (tin[s] != 0) continue;
            int top = 0;
            callStack[top++] = s;
            tin[s] = low[s] = ++timer;
            sccStack[sp++] = s;
            onStack[s] = true;
            while (top > 0) {
                int u = callStack[top - 1];
                if (idx[u] < g[u].size()) {
                    int v = g[u].get(idx[u]++);
                    if (tin[v] == 0) {
                        tin[v] = low[v] = ++timer;
                        sccStack[sp++] = v;
                        onStack[v] = true;
                        callStack[top++] = v;
                    } else if (onStack[v]) {
                        low[u] = Math.min(low[u], tin[v]);
                    }
                } else {
                    if (low[u] == tin[u]) {
                        count++;
                        int w;
                        do {
                            w = sccStack[--sp];
                            onStack[w] = false;
                        } while (w != u);
                    }
                    top--;
                    if (top > 0) {
                        int p = callStack[top - 1];
                        low[p] = Math.min(low[p], low[u]);
                    }
                }
            }
        }
        return count;
    }
}
