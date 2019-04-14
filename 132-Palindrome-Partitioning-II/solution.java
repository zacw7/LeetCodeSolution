class Solution {
    public int minCut(String s) {
        if (s == null || s.length() <= 1) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                dp[i] = 0;
                continue;
            }
            dp[i] = i - 1;
            for (int j = 1; j < i; j++) {
                if (isPalindrome(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()];
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        for (int left = 0, right = s.length() - 1; left < right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }
}