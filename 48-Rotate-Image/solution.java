class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length - 1;
        for (int i = 0; i < n - i; i++) {
            for (int j = i; j < n - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - j][i];
                matrix[n - j][i] = matrix[n - i][n - j];
                matrix[n - i][n - j] = matrix[j][n - i];
                matrix[j][n - i] = tmp;
            }
        }
    }
}