class Solution {
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int horizon = 0;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    horizon++;
                }
                if (i == 0) {
                    sum += grid[i][j];
                } else {
                    sum += Math.abs(grid[i][j] - grid[i-1][j]);
                }
                if (i == N - 1) {
                    sum += grid[i][j];
                }
                if (j == 0) {
                    sum += grid[i][j];
                } else {
                    sum += Math.abs(grid[i][j] - grid[i][j-1]);
                }
                if (j == N - 1) {
                    sum += grid[i][j];
                }
            }
        }
        sum += 2 * horizon;
        return sum;
    }
}