class Solution {
    // dp
    // TC: O(MN) - M is the ring length, N is the key length
    // SC: O(M)
    public int findRotateSteps(String ring, String key) {
        int LEN = ring.length();
        int[] dp = new int[LEN];
        for (int j = 1; j < ring.length(); j++) {
            dp[j] = Math.min(j, ring.length() - j);
        }
        for (int i = 1; i <= key.length(); i++) {
            int[] prev = dp;
            dp = new int[LEN];
            Arrays.fill(dp, Integer.MAX_VALUE);
            char c = key.charAt(i - 1);
            for (int j = 0; j < LEN * 2; j++) {
                if (c == ring.charAt(j % LEN)) {
                    dp[j % LEN] = prev[j % LEN] + 1;
                } else if (j > 0 && dp[(j - 1) % LEN] != Integer.MAX_VALUE) {
                    dp[j % LEN] = dp[(j - 1) % LEN] + 1;
                }
            }
            for (int j = LEN * 2 - 1; j >= 0; j--) {
                if (j + 1 < LEN * 2 - 1 && dp[(j + 1) % LEN] != Integer.MAX_VALUE) {
                    dp[j % LEN] = Math.min(dp[j % LEN], dp[(j + 1) % LEN] + 1);
                }
            }
        }

        int minStep = Integer.MAX_VALUE;
        for (int s : dp) {
            minStep = Math.min(minStep, s);
        }
        return minStep;
    }
}