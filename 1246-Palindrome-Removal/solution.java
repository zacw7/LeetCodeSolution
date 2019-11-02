class Solution {
    public int minimumMoves(int[] arr) {
        int N = arr.length;
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            for (int i = 0, j = len - 1; j < N; i++, j++) {
                dp[i][j] = dp[i + 1][j] + 1;
                if (arr[i] == arr[i + 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 2][j] + 1);
                }
                for (int k = i + 2; k <= j; k++) {
                    if (arr[i] == arr[k]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][k - 1] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][N - 1];
    }
}