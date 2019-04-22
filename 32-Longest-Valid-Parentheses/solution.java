class Solution {
    // dp
    // T: O(n)
    // S: O(n)
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        // dp[i][0]: the longest valid parentheses of substring end with the i-th character
        // dp[i][1]: the number of unmatched '(' of substring end with the i-th character
        int[][] dp = new int[s.length() + 1][2];
        dp[0][0] = dp[0][1] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i - 1) == '(') {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                if (dp[i - 1][1] > 0) {
                    dp[i][0] = dp[i - 1][0] + 2;
                    dp[i][1] = dp[i - 1][1] - 1;
                    dp[i][0] += dp[i - dp[i][0]][0];
                } else {
                    dp[i][0] = dp[i][1] = 0;
                }
            }
        }

        int max = 0;
        for (int[] d : dp) {
            max = Math.max(max, d[0]);
        }
        return max;
    }
}