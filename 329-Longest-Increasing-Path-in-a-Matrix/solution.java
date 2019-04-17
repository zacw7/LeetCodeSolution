class Solution {
    private int R, C;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        R = matrix.length;
        C = matrix[0].length;
        int max = 0;
        int memo[][] = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                max = Math.max(max, findLen(matrix, r, c, memo));
            }
        }

        return max;
    }

    private int findLen(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] > 0) {
            return memo[r][c];
        }
        int len = 0;
        if (r > 0 && matrix[r][c] < matrix[r - 1][c]) {
            len = Math.max(len, findLen(matrix, r - 1, c, memo));
        }
        if (r + 1 < R && matrix[r][c] < matrix[r + 1][c]) {
            len = Math.max(len, findLen(matrix, r + 1, c, memo));
        }
        if (c > 0 && matrix[r][c] < matrix[r][c - 1]) {
            len = Math.max(len, findLen(matrix, r, c - 1, memo));
        }
        if (c + 1 < C && matrix[r][c] < matrix[r][c + 1]) {
            len = Math.max(len, findLen(matrix, r, c + 1, memo));
        }
        memo[r][c] = len + 1;
        return memo[r][c];
    }
}