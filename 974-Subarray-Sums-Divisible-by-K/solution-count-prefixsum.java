class Solution {
    // prefixsum + hash
    // T: O(N)
    // S: O(K + N)
    public int subarraysDivByK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[A.length + 1];
        for (int i = 1; i <= A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
        }

        int count = 0;
        int[] modCount = new int[K];
        for (int sum : prefixSum) {
            count += modCount[(sum % K + K) % K];
            modCount[(sum % K + K) % K]++;
        }

        return count;
    }
}