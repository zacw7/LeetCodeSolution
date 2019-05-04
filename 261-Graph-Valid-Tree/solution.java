class Solution {
    public boolean validTree(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        // check loop
        for (int[] edge : edges) {
            int n1 = dsu.find(edge[0]);
            int n2 = dsu.find(edge[1]);
            if (n1 == n2) {
                return false;
            }
            dsu.union(edge[0], edge[1]);
        }

        // check isolated node
        int root = dsu.find(0);
        for (int i = 1; i < n; i++) {
            if (root != dsu.find(i)) {
                return false;
            }
        }
        return true;
    }

    class DSU {
        private int[] parents;
        DSU(int n) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
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
            while (x != parents[x]) {
                int tmp = parents[x];
                parents[x] = p;
                x = tmp;
            }
            return p;
        }
    }
}