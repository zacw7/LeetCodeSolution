class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        if (n >= 0) dp[0] = 1;
        if (n >= 1) dp[1] = 9;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] * 10 - dp[i - 1] * (i - 1);
        int sum = 0;
        for (int c : dp) sum += c;
        return sum;
    }
}