class Solution {
    // DP [TLE]
    // T: O(N*K)
    // S: O(K)
    public int subarraysDivByK(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int count = 0;
        int[] modCount = new int[K];

        for (int num : A) {
            int[] prev = modCount.clone();
            if (num < 0) {
                num = (num % K) + K;
            }
            for (int i = 0; i < K; i++) {
                modCount[(num + i) % K] = prev[i];
            }
            modCount[num % K]++;
            count += modCount[0];
        }

        return count;
    }
}