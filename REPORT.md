### DAA Assignment3 - Report and Defense

##### Problem 1 and 2 - Number of Provinces
+ DFS (iterative stack) counts connected components of the adjacency matrix: O(n²) time, O(n) memory.
+ DSU with path compression and union by rank starts with n components and decrements on every successful union: O(n² α(n)).

##### Problem 3 and 4 - Min Cost Spanning Tree
+ Kruskal: sort all n(n-1)/2 edges and add them with DSU until n-1 edges are taken: O(n² log n).
+ Prim: array-based version grows the tree from point 0 by the nearest outside point: O(n²), better for a dense graph.

##### Problem 5 and 6 - Software Dependency Cycles
+ Kosaraju: DFS for finishing order, then DFS on the reversed graph in reverse finishing order; each start is one SCC.
+ Tarjan: single DFS with tin/low values and an SCC stack; a vertex with low == tin is a root of an SCC.
+ Both are O(n + m) and iterative to avoid stack overflow.

##### Problem 7 and 8 - Course Schedule
+ DFS: three colors, an edge to a vertex in the current path means a cycle.
+ Kahn: process vertices with in-degree 0; all vertices processed means no cycle. Both O(V + E).

##### Problem 9 and 10 - Course Schedule II
+ DFS: reversed finishing order is a topological order; a cycle gives an empty array.
+ Kahn: the queue order is the topological order; fewer than V processed vertices gives an empty array.
