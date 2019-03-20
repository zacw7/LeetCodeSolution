class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int cur = countHelper(grid, i, j);
                    if (cur > max) max = cur;
                }
            }
        }
        return max;
    }

    private int countHelper(int[][] grid, int x, int y) {
        int up = 0, down = 0, left = 0, right = 0;
        grid[x][y] = -1;
        if (x > 0 && grid[x - 1][y] == 1) up = countHelper(grid, x - 1, y);
        if (x < grid.length - 1 && grid[x + 1][y] == 1) down = countHelper(grid, x + 1, y);
        if (y > 0 && grid[x][y - 1] == 1) left = countHelper(grid, x, y - 1);
        if (y < grid[x].length - 1 && grid[x][y + 1] == 1) right = countHelper(grid, x, y + 1);
        return 1 + up + down + left + right;
    }
}