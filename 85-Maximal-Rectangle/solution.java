class Solution {
    // T: O(n)
    // S: O(n)
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ROW = matrix.length, COL = matrix[0].length;
        int[][] memo = new int[ROW][COL];
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (matrix[r][c] == '1') {
                    if (r == 0) {
                        memo[r][c] = 1;
                    } else {
                        memo[r][c] = memo[r - 1][c] + 1;
                    }
                }
            }
        }

        int max = 0;
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (memo[r][c] > 0) {
                    int height = memo[r][c];
                    max = Math.max(max, height);
                    for (int i = c - 1; i >= 0 && memo[r][i] > 0; i--) {
                        height = Math.min(height, memo[r][i]);
                        max = Math.max(max, height * (c - i + 1));
                    }
                }
            }
        }

        return max;
    }
}