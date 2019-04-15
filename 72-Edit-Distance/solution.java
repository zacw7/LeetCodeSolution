class Solution {
    // T: O(mn)
    // S: O(mn)
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;

        int len1 = word1.length(), len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return Math.max(len1, len2);
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) dp[i][0] = i;
        for (int j = 1; j <= len2; j++) dp[0][j] = j;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int insertOrDelete = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], insertOrDelete);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, insertOrDelete);
                }
            }
        }
        return dp[len1][len2];
    }
}