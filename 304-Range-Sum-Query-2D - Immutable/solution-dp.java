class NumMatrix {

    private int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int R = matrix.length, C = matrix[0].length;
        sums = new int[R + 1][C + 1];
        for (int r = 1; r <= R; r++) {
            for (int c = 1 ; c <= C; c++) {
                sums[r][c] = sums[r][c - 1] + sums[r - 1][c]
                        - sums[r - 1][c - 1] + matrix[r - 1][c - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] + sums[row1][col1]
                - sums[row1][col2 + 1] - sums[row2 + 1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */