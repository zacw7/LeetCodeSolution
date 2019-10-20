class Solution {
    // dp
    // TC: O(n^2)
    // SC: O(n)
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = profit.length;
        Integer[] idxs = new Integer[N];
        for (int i = 0; i < N; i++) {
            idxs[i] = i;
        }
        Arrays.sort(idxs, (a, b) -> endTime[a] - endTime[b]);
        int[] dp = new int[N + 1];
        dp[1] = profit[idxs[0]];
        for (int i = 2; i <= N; i++) {
            int idx = idxs[i - 1];
            int s = startTime[idx], e = endTime[idx], p = profit[idx];
            dp[i] = Math.max(p, dp[i - 1]);
            for (int j = i - 1; j > 0; j--) {
                int idx2 = idxs[j - 1];
                if (endTime[idx2] <= s) {
                    dp[i] = Math.max(dp[i], dp[j] + p);
                    break;
                }
            }
        }
        return dp[N];
    }
}