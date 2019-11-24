class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] reachable = new boolean[m][n];
        for (int r = 0; r < m; r++) {
            int count = 0;
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    count++;
                }
            }
            if (count > 1) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == 1) {
                        reachable[r][c] = true;
                    }
                }
            }
        }

        for (int c = 0; c < n; c++) {
            int count = 0;
            for (int r = 0; r < m; r++) {
                if (grid[r][c] == 1) {
                    count++;
                }
            }
            if (count > 1) {
                for (int r = 0; r < m; r++) {
                    if (grid[r][c] == 1) {
                        reachable[r][c] = true;
                    }
                }
            }
        }

        int res = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 && reachable[r][c]) {
                    res++;
                }
            }
        }
        return res;
    }
}