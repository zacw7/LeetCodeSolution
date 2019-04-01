class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        return helper(A, 0, A.length - 1, K);
    }

    private double helper(int[] A, int start, int end, int K) {
        if (K == 1) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += A[i];
            }
            return (double) sum / (end - start + 1);
        } else {
            double max = Double.MIN_VALUE;
            for (int i = start; i <= end - K + 1; i++) {
                max = Math.max(max, helper(A, start, i, 1) + helper(A, i + 1, end, K - 1));
            }
            return max;
        }
    }
}