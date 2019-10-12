class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;

        for (int r = 1; r < R; r++) {
            for (int c = 1; c < C; c++) {
                if (matrix[r][c] != matrix[r - 1][c - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}