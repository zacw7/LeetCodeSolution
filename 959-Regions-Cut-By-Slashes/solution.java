class Solution {
    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int N = grid.length;
        DSU dsu = new DSU(N * N * 4);
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                Cell cell = new Cell(N, r, c);
                if (grid[r].charAt(c) == '/') {
                    dsu.union(cell.left, cell.up);
                    dsu.union(cell.right, cell.down);
                } else if (grid[r].charAt(c) == '\\') {
                    dsu.union(cell.left, cell.down);
                    dsu.union(cell.right, cell.up);
                } else {
                    dsu.union(cell.left, cell.right);
                    dsu.union(cell.left, cell.up);
                    dsu.union(cell.left, cell.down);
                }
                if (r > 0) {
                    dsu.union(cell.up, new Cell(N, r - 1, c).down);
                }
                if (c > 0) {
                    dsu.union(cell.left, new Cell(N, r, c - 1).right);
                }
            }
        }
        return dsu.count;
    }

    class DSU {
        int count;
        int[] parents, rank;

        DSU(int S) {
            this.count = S;
            this.parents = new int[S];
            this.rank = new int[S];
            for (int i = 0; i < S; i++) {
                parents[i] = i;
            }
        }

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                if (rank[p_x] < rank[p_y]) {
                    parents[p_x] = parents[p_y];
                } else if (rank[p_x] > rank[p_y]) {
                    parents[p_y] = parents[p_x];
                } else {
                    parents[p_x] = parents[p_y];
                    rank[p_y]++;
                }
                count--;
            }
        }

        int find(int x) {
            if (parents[x] != x) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
    }

    class Cell {
        int id, left, right, up, down;
        Cell(int N, int r, int c) {
            this.id = (r * N  + c) * 4;
            this.left = id;
            this.right = id + 1;
            this.up = id + 2;
            this.down = id + 3;
        }
    }
}