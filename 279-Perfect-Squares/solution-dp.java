class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        if (n > 0) memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = i;
            int root = (int) Math.sqrt(i);
            if (root * root == i) {
                memo[i] = 1;
            } else {
                for (int j = 1, half = i / 2; j <= half; j++)
                    memo[i] = Math.min(memo[i], memo[j] + memo[i - j]);
            }
        }
        return memo[n];
    }
}