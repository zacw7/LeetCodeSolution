class Solution {
    public int maxRotateFunction(int[] A) {
        if (A == null || A.length <= 1) {
            return 0;
        }
        int sum = 0, cur = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            cur += A[i] * i;
        }
        int maxF = cur;
        for (int i = 0; i < A.length - 1; i++) {
            cur = cur - sum + A[i] * A.length;
            maxF = Math.max(maxF, cur);
        }
        return maxF;
    }
}