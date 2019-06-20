class Solution {
    // dfs
    int R, C;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        R = grid.length;
        C = grid[0].length;
        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r0, int c0) {
        grid[r0][c0] = '0';
        for (int[] d : dir) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && r < R && c >= 0 && c < C && grid[r][c] == '1') {
                dfs(grid, r, c);
            }
        }
    }
}