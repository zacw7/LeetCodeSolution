class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int r = 1; r < triangle.size(); r++) {
            List<Integer> cur = triangle.get(r);
            dp[r] = cur.get(r) + dp[r - 1];
            for (int c = cur.size() - 2; c >= 0; c--) { // from right to left
                if (c == 0) {
                    dp[0] += cur.get(0);
                } else {
                    dp[c] = Math.min(dp[c], dp[c - 1]) + cur.get(c);
                }
            }
            System.out.print(Arrays.toString(dp));
        }
        int min = Integer.MAX_VALUE;
        for (int sum : dp) min = Math.min(min, sum);
        return min;
    }
}