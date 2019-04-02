class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int R = matrix.length, C = matrix[0].length;
        int max = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == '1') {
                    max = Math.max(max, calcArea(matrix, r, c));
                }
            }
        }
        return max;
    }

    private int calcArea(char[][] matrix, int r, int c) {
        int len = 1;
        while (r + len < matrix.length && c + len < matrix[r].length && matrix[r + len][c + len] == '1') {
            // check row
            for (int i = c; i < c + len; i++) {
                if (matrix[r + len][i] == '0')  {
                    return len * len;
                }
            }
            // check column
            for (int i = r; i < r + len; i++) {
                if (matrix[i][c + len] == '0') return len * len;
            }
            len++;
        }
        return len * len;
    }
}