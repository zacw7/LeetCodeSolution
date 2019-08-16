class Solution {
    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return 0;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int R = A.length, C = A[0].length;
        int EDGE = R * C;
        DSU dsu = new DSU(R * C + 1);
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] == 1) {
                    if(r == 0 || c == 0 || r == R - 1 || c == C - 1) {
                        dsu.union(r * C + c, EDGE);
                    } else {
                        for (int[] d : dirs) {
                            int n_r = r + d[0], n_c = c + d[1];
                            if (A[n_r][n_c] == 1) {
                                dsu.union(r * C + c, n_r * C + n_c);
                            }
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] == 1 && dsu.find(r * C + c) != dsu.find(EDGE)) {
                    count++;
                }
            }
        }
        return count;
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