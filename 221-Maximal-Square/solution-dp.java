class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int R = matrix.length, C = matrix[0].length;
        int[][] dp = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dp[i][j] = matrix[i][j] - '0';
            }
        }
        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                if (dp[r][c] > 0)
                    dp[r][c] += Math.min(Math.min(dp[r][c - 1], dp[r - 1][c]), dp[r - 1][c - 1]);
            }
        }
        int max = 0;
        for (int[] row : dp) {
            for (int len : row) {
                max = Math.max(max, len * len);
            }
        }
        return max;
    }
}