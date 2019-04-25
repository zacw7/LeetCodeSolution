class Solution {
    // brute force
    // T: O(n^4)
    // S: O(1)
    // TLE
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null) {
            return 0;
        }
        int count = 0;
        for (int a = 0; a < A.length; a++) {
            for (int b = 0; b < B.length; b++) {
                for (int c = 0; c < C.length; c++) {
                    for (int d = 0; d < D.length; d++) {
                        if (A[a] + B[b] + C[c] + D[d] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}