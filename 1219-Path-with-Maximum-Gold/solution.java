class Solution {
    int R, C;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int getMaximumGold(int[][] grid) {
        R = grid.length;
        C = grid[0].length;
        int maxGold = 0;
        boolean[][] visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] > 0) {
                    maxGold = Math.max(maxGold, dfs(grid, r, c, visited));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int r0, int c0, boolean[][] visited) {
        visited[r0][c0] = true;
        int localMax = 0;
        for (int[] d : dirs) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && c >= 0 && r < R && c < C && !visited[r][c] && grid[r][c] > 0) {
                localMax = Math.max(localMax, dfs(grid, r, c, visited));
            }
        }
        visited[r0][c0] = false;
        return localMax + grid[r0][c0];
    }
}