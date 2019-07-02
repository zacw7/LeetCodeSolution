class Solution {
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        for (int i = 1; i <= books.length; i++) {
            int width = books[i - 1][0], height = books[i - 1][1];
            // new shelve
            dp[i] = dp[i - 1] + height;
            // same shelve
            for (int j = i - 1; j > 0 && width + books[j - 1][0] <= shelf_width; j--) {
                height = Math.max(height, books[j - 1][1]);
                width += books[j - 1][0];
                dp[i] = Math.min(dp[i], dp[j - 1] + height);
            }
        }
        return dp[books.length];
    }
}