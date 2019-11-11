class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] i : indices) {
            for (int r = 0; r < n; r++) {
                matrix[r][i[1]]++;
            }
            for (int c = 0; c < m; c++) {
                matrix[i[0]][c]++;
            }
        }
        int res = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (matrix[r][c] % 2 == 1) {
                    res++;
                }
            }
        }
        return res;
    }
}