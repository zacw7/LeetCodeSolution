class Solution {
    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        int[] sum = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            int cur = i, val = value[i];
            while (cur != -1) {
                sum[cur] += val;
                cur = parent[cur];
            }
        }
        if (sum[0] == 0) {
            return 0;
        }
        int res = 0;
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (visited[i]) {
                continue;
            }
            int cur = i;
            int count = 0;
            while (cur != -1) {
                if (sum[cur] == 0) {
                    break;
                } else if (!visited[cur]) {
                    count++;
                    visited[cur] = true;
                }
                cur = parent[cur];
            }
            if (cur == -1) {
                res += count;
            }
        }
        return res;
    }
}