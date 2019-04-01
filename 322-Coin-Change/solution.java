class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        for (int c : coins) if (c <= amount) memo[c] = 1;
        for (int i = 1; i <= amount; i++) {
            if (memo[i] == -1) {
                for (int c : coins) {
                    if (i - c > 0 && memo[i - c] != -1) {
                        memo[i] = (memo[i] == -1) ? memo[i - c] + 1 : Math.min(memo[i], memo[i - c] + 1);
                    }
                }
            }
        }
        return memo[amount];
    }
}