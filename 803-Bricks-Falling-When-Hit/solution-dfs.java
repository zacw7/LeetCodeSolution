class Solution {
    // DFS: TLE
    // T: O(nm)
    // S: O(1)

    int R, C;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] ans = new int[hits.length];
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return ans;
        }
        R = grid.length;
        C = grid[0].length;
        for (int i = 0; i < hits.length; i++) {
            int origin = grid[hits[i][0]][hits[i][1]];
            grid[hits[i][0]][hits[i][1]] = 0;
            int count = 0;
            if (origin != 0) {
                for (int c = 0; c < C; c++) {
                    if (origin == grid[0][c]) {
                        dfs(grid, 0, c, origin);
                    }
                }
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (grid[r][c] == origin) {
                            grid[r][c] = 0;
                            count++;
                        }
                    }
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    private void dfs(int[][] grid, int r, int c, int origin) {
        grid[r][c] = -origin;
        if (r > 0 && grid[r - 1][c] == origin) {
            dfs(grid, r - 1, c, origin);
        }
        if (r + 1 < R && grid[r + 1][c] == origin) {
            dfs(grid, r + 1, c, origin);
        }
        if (c > 0 && grid[r][c - 1] == origin) {
            dfs(grid, r, c - 1, origin);
        }
        if (c + 1 < C && grid[r][c + 1] == origin) {
            dfs(grid, r, c + 1, origin);
        }
    }
}