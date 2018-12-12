class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int n : A) {
            if (n < min) min = n;
            if (n > max) max = n;
        }
        int diff = max - min;
        return (diff > K * 2) ? diff - K * 2 : 0;
    }
}