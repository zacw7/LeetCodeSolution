class Solution {
    // dp + set
    // TC: O(N^2)
    // SC: O(N^2)
    public boolean queryString(String S, int N) {
        Set<Integer> seen = new HashSet();
        Set<Integer>[] dp = new Set[S.length()];
        for (int i = 0; i < S.length(); i++) {
            dp[i] = new HashSet();
            int d = S.charAt(i) - '0';
            if (d > 0) {
                dp[i].add(d);
            }
            if (i > 0 && !dp[i - 1].isEmpty()) {
                for (int n : dp[i - 1]) {
                    n <<= 1;
                    n += d;
                    if (n <= N) {
                        dp[i].add(n);
                    }
                }
            }
            seen.addAll(dp[i]);
            if (seen.size() == N) {
                return true;
            }
        }
        return false;
    }
}