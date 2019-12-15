class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int R = mat.length, C = mat[0].length;
        int[][] sum = new int[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            int cur = 0;
            for (int c = 1; c <= C; c++) {
                cur += mat[r - 1][c - 1];
                sum[r][c] = sum[r - 1][c] + cur;
            }
        }
        int res = 0;
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                for (int d = res; r - d >= 0 && c - d >= 0; d++) {
                    if (sum[r][c] - sum[r][c - d] - sum[r - d][c] + sum[r - d][c - d] <= threshold) {
                        res = Math.max(res, d);
                    }
                }
            }
        }
        return res;
    }
}