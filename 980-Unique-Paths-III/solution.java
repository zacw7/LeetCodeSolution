class Solution {
    int ans, R, C, obstacleCount;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int uniquePathsIII(int[][] grid) {
        ans = 0;
        obstacleCount = 0;
        R = grid.length;
        C = grid[0].length;
        boolean[][] visited = new boolean[R][C];
        int r0 = -1, c0 = -1;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    r0 = r;
                    c0 = c;
                } else if (grid[r][c] == -1) {
                    obstacleCount++;
                }
            }
        }
        visited[r0][c0] = true;
        dfs(grid, r0, c0, visited, 1);
        return ans;
    }

    private void dfs(int[][] grid, int r0, int c0, boolean[][] visited, int step) {
        if (grid[r0][c0] == 2) {
            if (step == R * C - obstacleCount) {
                ans++;
            }
            return;
        }
        for (int[] d : dir) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && r < R && c >= 0 && c < C && !visited[r][c] && grid[r][c] != -1) {
                visited[r][c] = true;
                dfs(grid, r, c, visited, step + 1);
                visited[r][c] = false;
            }
        }
    }

}