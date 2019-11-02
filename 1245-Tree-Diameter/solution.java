class Solution {
    public int treeDiameter(int[][] edges) {
        int N = edges.length;
        int[] degree = new int[N + 1];
        List<Integer>[] adjList = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i <= N; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            if (sz >= 2) {
                res++;
            }
            while (sz-- > 0) {
                int cur = queue.poll();
                for (int neigh : adjList[cur]) {
                    degree[neigh]--;
                    if (degree[neigh] == 1) {
                        queue.offer(neigh);
                    }
                }
            }
            if (!queue.isEmpty()) {
                res++;
            }
        }
        return res;
    }
}