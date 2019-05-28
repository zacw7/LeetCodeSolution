class Solution {
    // DP [TLE]
    // TC: O(N^2)
    // SC: O(N)
    public int shortestSubarray(int[] A, int K) {
        if (A[0] >= K) {
            return 1;
        }
        int[] prefixSum = new int[A.length + 1];
        int[] maxSum = new int[A.length];
        maxSum[0] = Math.max(0, A[0]);
        prefixSum[1] = A[0];
        int len = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; i++) {
            if (A[i] >= K) {
                return 1;
            }
            prefixSum[i + 1] = prefixSum[i] + A[i];
            maxSum[i] = Math.max(A[i], maxSum[i - 1] + A[i]);
            maxSum[i] = Math.max(0, maxSum[i]);
            if (maxSum[i] >= K) {
                for (int j = i; j >= 0 && i - j < len; j--) {
                    int sum = prefixSum[i + 1] - prefixSum[j];
                    if (sum >= K) {
                        len = i + 1 - j;
                        break;
                    }
                }
            }
        }
        return (len == Integer.MAX_VALUE) ? -1 : len;
    }
}