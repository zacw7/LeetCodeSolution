class Solution {
    // dp [TLE]
    // T: O(n^2)
    // S: O(n)
    public int maxWidthRamp(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int maxWidth = 0;
        int[] dp = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] <= A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + j - i);
                }
            }
            maxWidth = Math.max(maxWidth, dp[i]);
        }
        return maxWidth;
    }
}