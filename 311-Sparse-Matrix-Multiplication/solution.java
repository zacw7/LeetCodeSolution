class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int A_ROW = A.length, A_COL = A[0].length;
        int B_ROW = B.length, B_COL = B[0].length;
        int[][] res = new int[A_ROW][B_COL];

        for (int i = 0; i < A_ROW; i++) {
            for (int j = 0; j < B_COL; j++) {
                for (int k = 0; k < A_COL; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return res;
    }
}