class Solution {
    public int makeConnected(int n, int[][] connections) {
        int redundant = 0;
        DSU dsu = new DSU(n);
        for (int[] conn : connections) {
            if (dsu.find(conn[0]) == dsu.find(conn[1])) {
                redundant++;
            } else {
                dsu.union(conn[0], conn[1]);
            }
        }
        int op = 0;
        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != dsu.find(0)) {
                if (redundant == 0) {
                    return -1;
                } else {
                    dsu.union(i, 0);
                    redundant--;
                    op++;
                }
            }
        }
        return op;
    }

    class DSU {
        int[] rank, parent;

        DSU(int N) {
            this.rank = new int[N];
            this.parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                if (rank[p_x] > rank[p_y]) {
                    parent[p_y] = p_x;
                } else if (rank[p_x] < rank[p_y]) {
                    parent[p_x] = p_y;
                } else {
                    parent[p_y] = p_x;
                    rank[p_x]++;
                }
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}