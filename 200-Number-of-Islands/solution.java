class Solution {
    private int R, C;
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
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

    private void dfs(char[][] grid, int r, int c) {
        grid[r][c] = '0';
        if (r > 0 && grid[r - 1][c] == '1') dfs(grid, r - 1, c);
        if (c > 0 && grid[r][c - 1] == '1') dfs(grid, r, c - 1);
        if (r < R - 1 && grid[r + 1][c] == '1') dfs(grid, r + 1, c);
        if (c < C - 1 && grid[r][c + 1] == '1') dfs(grid, r, c + 1);
    }
}