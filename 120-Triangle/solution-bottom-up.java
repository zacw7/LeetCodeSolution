class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        List<Integer> lastRow = triangle.get(dp.length - 1);
        for (int i = 0; i < dp.length; i++) dp[i] = lastRow.get(i);

        for (int r = triangle.size() - 2; r >= 0; r--) {
            List<Integer> row = triangle.get(r);
            for (int c = 0; c < row.size(); c++) {
                dp[c] = row.get(c) +  Math.min(dp[c], dp[c + 1]);
            }
        }
        return dp[0];
    }
}