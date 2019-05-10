class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        int step = 1;
        int dr = 1, dc = 1;
        int i = 0;
        while (i < res.length) {
            if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                res[i][0] = r0;
                res[i][1] = c0;
                i++;
            }
            if (dc == 0 && dr == 0) {
                step++;
                dr = dc = step;
            }
            if (dc > 0) {
                if (step % 2 == 1) {
                    c0++;
                } else {
                    c0--;
                }
                dc--;
            } else if (dr > 0) {
                if (step % 2 == 1) {
                    r0++;
                } else {
                    r0--;
                }
                dr--;
            }
        }
        return res;
    }
}