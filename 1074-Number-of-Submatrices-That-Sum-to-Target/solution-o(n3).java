class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        int R = matrix.length, C = matrix[0].length;
        int res = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 1; c < C; c++) {
                matrix[r][c] += matrix[r][c - 1];
            }
        }
        for (int i = 0; i < C; i++) {
            for (int j = i; j < C; j++) {
                Map<Integer, Integer> map = new HashMap();
                map.put(0, 1);
                int cur = 0;
                for (int k = 0; k < R; k++) {
                    cur += matrix[k][j] - (i == 0 ? 0 : matrix[k][i - 1]);
                    res += map.getOrDefault(cur - target, 0);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}