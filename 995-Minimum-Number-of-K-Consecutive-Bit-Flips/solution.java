class Solution {
    // greedy
    // TC: O(kn)
    // SC: O(1)
    public int minKBitFlips(int[] A, int K) {
        int count = 0, i = 0;
        while (i + K <= A.length) {
            if (A[i] == 0) {
                count++;
                for (int j = i; j < i + K; j++) {
                    A[j] = 1 - A[j];
                }
            }
            i++;
        }
        while (i < A.length) {
            if (A[i] == 0) {
                return -1;
            }
            i++;
        }
        return count;
    }
}