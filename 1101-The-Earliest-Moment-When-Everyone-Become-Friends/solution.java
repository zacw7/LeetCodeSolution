class Solution {
    public int earliestAcq(int[][] logs, int N) {
        if (N == 0 || logs == null || logs.length == 0) {
            return -1;
        }
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        DSU dsu = new DSU(N);
        for (int[] log : logs) {
            dsu.union(log[1], log[2]);
            if (dsu.allFriends()) {
                return log[0];
            }
        }
        return -1;
    }

    class DSU {
        int[] parents;

        DSU(int N) {
            this.parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = i;
            }
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                parents[p_x] = p_y;
            }
        }

        int find(int x) {
            int p = parents[x];
            while (p != parents[p]) {
                p = parents[p];
            }
            while (x != p) {
                int tmp = parents[x];
                parents[x] = p;
                x = tmp;
            }
            return p;
        }

        boolean allFriends() {
            int group = find(0);
            for (int i = 1; i < parents.length; i++) {
                if (group != find(i)) {
                    return false;
                }
            }
            return true;
        }
    }
}