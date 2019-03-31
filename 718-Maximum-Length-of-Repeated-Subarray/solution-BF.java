class Solution {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) max = Math.max(max, helper(A, B, i, j));
            }
        }
        return max;
    }

    private int helper(int[] A, int[] B, int ia, int ib) {
        int count = 1;
        for (ia += 1, ib += 1; ia < A.length && ib < B.length && A[ia] == B[ib]; ia++, ib++) count++;
        return count;
    }
}