class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] flag = new int[N];
        for (int i = 0; i < N; i++) {
            if (flag[i] == 0 && !dfs(i, 1, graph, flag)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int n, int cur, int[][] graph, int[] flag) {
        if (flag[n] != 0) {
            return flag[n] == cur;
        }
        flag[n] = cur;
        for (int neigh : graph[n]) {
            if (!dfs(neigh, -cur, graph, flag)) {
                flag[n] = 0;
                return false;
            }
        }
        return true;
    }
}