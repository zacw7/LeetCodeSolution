class Solution {
    // dp: TLE
    // TC: O(kn^2)
    // SC: O(n)
    public int maximizeSweetness(int[] sweetness, int K) {
        int N = sweetness.length;
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + sweetness[i - 1];
        }
        int[] prev = prefixSum.clone();
        for (int i = 1; i <= K; i++) {
            int[] cur = new int[N + 1];
            for (int j = i; j <= N; j++) {
                for (int k = j - 1; k >= 0; k--) {
                    if (prev[k] < cur[j]) {
                        break;
                    }
                    cur[j] = Math.max(cur[j], Math.min(prev[k], prefixSum[j] - prefixSum[k]));
                }
            }
            prev = cur;
        }
        return prev[N];
    }
}