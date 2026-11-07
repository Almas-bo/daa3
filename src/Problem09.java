import java.util.ArrayList;
import java.util.List;

public class Problem09 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) g[i] = new ArrayList<>();
        for (int[] p : prerequisites) g[p[1]].add(p[0]);

        int[] state = new int[numCourses];
        int[] idx = new int[numCourses];
        int[] stack = new int[numCourses];
        int[] finish = new int[numCourses];
        int size = 0;
        for (int s = 0; s < numCourses; s++) {
            if (state[s] != 0) continue;
            int top = 0;
            stack[top++] = s;
            state[s] = 1;
            while (top > 0) {
                int u = stack[top - 1];
                if (idx[u] < g[u].size()) {
                    int v = g[u].get(idx[u]++);
                    if (state[v] == 1) return new int[0];
                    if (state[v] == 0) {
                        state[v] = 1;
                        stack[top++] = v;
                    }
                } else {
                    state[u] = 2;
                    finish[size++] = u;
                    top--;
                }
            }
        }
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) result[i] = finish[numCourses - 1 - i];
        return result;
    }
}
