class Solution {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int cur = A[i - 1][j];
                if (j > 0) cur = Math.min(A[i - 1][j - 1], cur);
                if (j < A[i].length - 1) cur = Math.min(A[i - 1][j + 1], cur);
                A[i][j] += cur;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = A.length - 1, j = 0; j < A[i].length; j++) {
            min = Math.min(min, A[i][j]);
        }
        return min;
    }
}