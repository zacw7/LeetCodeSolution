class Solution {
    public boolean splitArray(int[] nums) {
        int N = nums.length;
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i - 1];
        }
        for (int j = 4; j + 3 <= N; j++) {
            Set<Integer> seen = new HashSet();
            for (int i = 1; i + 1 < j; i++) {
                if (prefixSum[i] == prefixSum[j - 1] - prefixSum[i + 1]) {
                    seen.add(prefixSum[i]);
                }
            }
            for (int k = N - 1; k > j + 1; k--) {
                if (prefixSum[N] - prefixSum[k] == prefixSum[k - 1] - prefixSum[j]
                        && seen.contains(prefixSum[N] - prefixSum[k])) {
                    return true;
                }
            }
        }
        return false;
    }
}