class Solution {
    // T: O(n)
    // S: O(1)
    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int maxI = 0, maxScore = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            maxScore = Math.max(maxScore, A[maxI] + A[j] + maxI - j);
            if (A[j] + j > A[maxI] + maxI) {
                maxI = j;
            }
        }
        return maxScore;
    }
}