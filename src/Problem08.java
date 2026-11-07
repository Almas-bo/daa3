import java.util.ArrayList;
import java.util.List;

public class Problem08 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new List[numCourses];
        for (int i = 0; i < numCourses; i++) g[i] = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites) {
            g[p[1]].add(p[0]);
            indeg[p[0]]++;
        }
        int[] queue = new int[numCourses];
        int head = 0;
        int tail = 0;
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) queue[tail++] = i;
        }
        while (head < tail) {
            int u = queue[head++];
            for (int v : g[u]) {
                if (--indeg[v] == 0) queue[tail++] = v;
            }
        }
        return tail == numCourses;
    }
}
