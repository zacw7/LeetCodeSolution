class Solution {
    // dp
    // TC: O(MN)
    // SC: O(MN)
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[key.length() + 1][ring.length()];
        for (int j = 1; j < ring.length(); j++) {
            dp[0][j] = Math.min(j, ring.length() - j);
        }
        int LEN = ring.length();
        for (int i = 1; i <= key.length(); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            char c = key.charAt(i - 1);
            for (int j = 0; j < LEN * 2; j++) {
                if (c == ring.charAt(j % LEN)) {
                    dp[i][j % LEN] = dp[i - 1][j % LEN] + 1;
                } else if (j > 0 && dp[i][(j - 1) % LEN] != Integer.MAX_VALUE) {
                    dp[i][j % LEN] = dp[i][(j - 1) % LEN] + 1;
                }
            }
            for (int j = LEN * 2 - 1; j >= 0; j--) {
                if (j + 1 < LEN * 2 - 1 && dp[i][(j + 1) % LEN] != Integer.MAX_VALUE) {
                    dp[i][j % LEN] = Math.min(dp[i][j % LEN], dp[i][(j + 1) % LEN] + 1);
                }
            }
        }

        int minStep = Integer.MAX_VALUE;
        for (int s : dp[key.length()]) {
            minStep = Math.min(minStep, s);
        }
        return minStep;
    }
}