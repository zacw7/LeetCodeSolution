class Solution {
    // union-find
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int R = board.length, C = board[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        DSU dsu = new DSU(R * C + 1);
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'O') {
                    if (r == 0 || c == 0 || r == R - 1 || c == C - 1) {
                        dsu.union(R * C, r * C + c);
                    }
                    for (int[] d : dir) {
                        int x = r + d[0], y = c + d[1];
                        if (x >= 0 && x < R && y >= 0 && y < C && board[x][y] == 'O') {
                            dsu.union(r * C + c, x * C + y);
                        }
                    }
                }
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'O' && dsu.find(R * C) != dsu.find(r * C + c)) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    class DSU {
        int[] parents;

        DSU(int size) {
            this.parents = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
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

        void union(int x, int y) {
            int p_x = find(x);
            int p_y = find(y);
            if (p_x != p_y) {
                parents[p_x] = p_y;
            }
        }
    }
}