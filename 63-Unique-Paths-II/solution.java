class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0
                || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        paths[m - 1][n - 1] = 1;
        for (int i = m - 2; i >= 0 && obstacleGrid[i][n - 1] != 1; i--) paths[i][n - 1] = 1;
        for (int j = n - 2; j >= 0 && obstacleGrid[m - 1][j] != 1; j--) paths[m - 1][j] = 1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) paths[i][j] = paths[i][j + 1] + paths[i + 1][j];
            }
        }
        return paths[0][0];
    }
}