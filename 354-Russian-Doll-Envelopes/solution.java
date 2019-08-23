class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int len = 0;
        int[] dp = new int[envelopes.length];
        for (int[] env : envelopes) {
            int i = Arrays.binarySearch(dp, 0, len, env[1]);
            if (i < 0) {
                i = -i - 1;
            }
            dp[i] = env[1];
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}