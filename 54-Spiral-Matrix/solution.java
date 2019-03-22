class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        int layer = (Math.min(n, m) + 1) / 2;
        for (int i = 0; i < layer; i++) {
            res.add(matrix[i][i]);
            if (n - i - 1 > i) {
                for (int col = i + 1; col < n - i; col++) res.add(matrix[i][col]);
            }
            if (m - i - 1 > i) {
                for (int row = i + 1; row < m - i; row++) res.add(matrix[row][n - i - 1]);
            }
            if (n - i - 1 > i && m - i - 1 > i) {
                for (int col = n - i - 2; col > i; col--) res.add(matrix[m - i - 1][col]);
                for (int row = m - i - 1; row > i; row--) res.add(matrix[row][i]);
            }
        }
        return res;
    }
}