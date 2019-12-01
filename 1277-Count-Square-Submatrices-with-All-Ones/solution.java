class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int R = matrix.length, C = matrix[0].length;
        int res = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 1) {
                    res++;
                    for (int d = 1; r - d >= 0 && c - d >= 0 && matrix[r - 1][c - 1] >= d; d++) {
                        boolean flag = true;
                        for (int i = 1; i <= d; i++) {
                            if (matrix[r - i][c] == 0 || matrix[r][c - i] == 0) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            res++;
                            matrix[r][c]++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}