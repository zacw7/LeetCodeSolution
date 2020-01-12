class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int R = mat.length, C = mat[0].length;
        int[][] ans = new int[R][C];
        int[][] sum = new int[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            int cur = 0;
            for (int c = 1; c <= C; c++) {
                cur += mat[r - 1][c - 1];
                sum[r][c] = sum[r - 1][c] + cur;
            }
        }
        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                int r1 = r - K - 1, r2 = r + K;
                int c1 = c - K - 1, c2 = c + K;
                if (r1 < 0) {
                    r1 = 0;
                }
                if (c1 < 0) {
                    c1 = 0;
                }
                if (r2 > R) {
                    r2 = R;
                }
                if (c2 > C) {
                    c2 = C;
                }
                ans[r - 1][c - 1] = sum[r2][c2] + sum[r1][c1] - sum[r1][c2] - sum[r2][c1];
            }
        }
        return ans;
    }
}