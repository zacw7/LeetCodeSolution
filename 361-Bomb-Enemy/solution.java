class Solution {
    int R, C;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        R = grid.length;
        C = grid[0].length;
        int[][] kills = new int[R][C];

        int max = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '0') {
                    kills[r][c] += killHelper(grid, r, c, dir[0]);
                    kills[r][c] += killHelper(grid, r, c, dir[1]);
                    kills[r][c] += killHelper(grid, r, c, dir[2]);
                    kills[r][c] += killHelper(grid, r, c, dir[3]);
                    max = Math.max(max, kills[r][c]);
                }
            }
        }
        return max;
    }

    private int killHelper(char[][] grid, int r, int c, int[] dir) {
        r += dir[0];
        c += dir[1];
        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == 'W') {
            return 0;
        }
        int res = (grid[r][c] == 'E') ? 1 : 0;
        return res + killHelper(grid, r, c, dir);
    }
}