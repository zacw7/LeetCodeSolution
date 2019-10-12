class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A.length == 0) return 0;
        int max = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int delta = A[j] - A[i];
                int cur = 2;
                int prev = j;
                for (int k = prev + 1; k < A.length; k++) {
                    if (A[k] - A[prev] == delta) {
                        cur++;
                        prev = k;
                    }
                }
                max = Math.max(cur, max);
            }
        }
        return max;
    }
}