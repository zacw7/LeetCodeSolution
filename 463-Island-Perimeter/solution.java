class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int R = grid.length, C = grid[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    if (r == 0 || grid[r - 1][c] == 0) {
                        ans++;
                    }
                    if (c == 0 || grid[r][c - 1] == 0) {
                        ans++;
                    }
                    if (r == R - 1 || grid[r + 1][c] == 0) {
                        ans++;
                    }
                    if (c == C - 1 || grid[r][c + 1] == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}