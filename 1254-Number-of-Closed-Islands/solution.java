class Solution {
    public int closedIsland(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        DSU dsu = new DSU(R * C + 1);
        int EDGE = R * C;
        for (int r = 0; r < R; r++) {
            if (grid[r][0] == 0) {
                dsu.union(EDGE, r * C);
            }
            if (grid[r][C - 1] == 0) {
                dsu.union(EDGE, r * C + C - 1);
            }
        }
        for (int c = 1; c < C - 1; c++) {
            if (grid[0][c] == 0) {
                dsu.union(EDGE, c);
            }
            if (grid[R - 1][c] == 0) {
                dsu.union(EDGE, (R - 1) * C + c);
            }
        }
        for (int r = 1; r < R - 1; r++) {
            for (int c = 1; c < C - 1; c++) {
                if (grid[r][c] == 0) {
                    for (int[] d : dirs) {
                        int x = r + d[0], y = c + d[1];
                        if (x >= 0 && y >= 0 && x < R && y < C && grid[x][y] == 0) {
                            dsu.union(r * C + c, x * C + y);
                        }
                    }
                }
            }
        }
        Set<Integer> islands = new HashSet();
        for (int r = 1; r < R - 1; r++) {
            for (int c = 1; c < C - 1; c++) {
                if (grid[r][c] == 0) {
                    int root = dsu.find(r * C + c);
                    if (root != dsu.find(EDGE)) {
                        islands.add(root);
                    }
                }
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(dsu.find(r * C + c) + " ");
            }
            System.out.println("");
        }
        return islands.size();
    }

    class DSU {
        int[] parents;
        int groups = 0;

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
                groups--;
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