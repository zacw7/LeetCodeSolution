class Solution {
    // dp
    // Time: O(n)
    // Space: O(n)
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int R = dungeon.length, C = dungeon[0].length;
        int[][] dp = new int[R][C];
        dp[R - 1][C - 1] = Math.max(1, -dungeon[R - 1][C - 1] + 1);
        for (int r = R - 2, c = C - 1; r >= 0; r--) {
            dp[r][c] =  Math.max(1, dp[r + 1][c] - dungeon[r][c]);
        }
        for (int r = R - 1, c = C - 2; c >= 0; c--) {
            dp[r][c] =  Math.max(1, dp[r][c + 1] - dungeon[r][c]);
        }
        for (int r = R - 2; r >= 0; r--) {
            for (int c = C - 2; c >= 0; c--) {
                dp[r][c] = Math.min(Math.max(1, dp[r + 1][c] - dungeon[r][c]),
                        Math.max(1, dp[r][c + 1] - dungeon[r][c]));
            }
        }
        return dp[0][0];
    }
}