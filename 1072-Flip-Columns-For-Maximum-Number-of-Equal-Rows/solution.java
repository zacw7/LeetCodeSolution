class Solution {
    int R, C;
    int maxRow = 0;
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        R = matrix.length;
        C = matrix[0].length;
        int[] rowValues = new int[matrix.length];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 1) {
                    rowValues[r]++;
                }
            }
            if (rowValues[r] == 0 || rowValues[r] == C) {
                maxRow++;
            }
        }
        maxEqual(matrix, 0, new int[R]);
        return maxRow;
    }

    private void maxEqual(int[][] matrix, int c, int[] rowValues) {
        int equalRows = 0;
        for (int r = 0; r < R; r++) {
            if (rowValues[r] == 0 || rowValues[r] == c) {
                equalRows++;
            }
        }
        if (c == C) {
            maxRow = Math.max(maxRow, equalRows);
        }
        if (equalRows <= maxRow) {
            return;
        }
        int[] cur = rowValues.clone();
        for (int r = 0; r < R; r++) {
            if (matrix[r][c] == 1) {
                cur[r]++;
            }
        }
        maxEqual(matrix, c + 1, cur);
        for (int r = 0; r < R; r++) {
            if (matrix[r][c] == 0) {
                rowValues[r]++;
            }
        }
        maxEqual(matrix, c + 1, rowValues);
    }
}