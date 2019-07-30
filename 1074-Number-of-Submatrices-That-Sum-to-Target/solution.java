class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int R = matrix.length, C = matrix[0].length;
        int[][] dp = new int[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            int[] tmp = new int[C + 1];
            for (int c = 1; c <= C; c++) {
                tmp[c] = matrix[r - 1][c - 1];
                if (c > 0) {
                    tmp[c] += tmp[c - 1];
                }
                dp[r][c] = tmp[c];
                if (r > 0) {
                    dp[r][c] += dp[r - 1][c];
                }
            }
        }
        int count = 0;
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        if (dp[r][c] - dp[i][c] - dp[r][j] + dp[i][j] == target) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}