class Solution {
    int ans = Integer.MAX_VALUE;
    int W = 0;
    public int minHeightShelves(int[][] books, int shelf_width) {
        if (books == null || books.length == 0) {
            return 0;
        }
        W = shelf_width;
        dfs(books, 0, 0, 0, 0);
        return ans;
    }

    Map<Integer, Integer> cache = new HashMap();
    private void dfs(int[][] books, int i, int width_left, int curHeight, int total) {
        if (total + curHeight > ans || total + curHeight >= cache.getOrDefault(i * 1000 + width_left, Integer.MAX_VALUE)) {
            return;
        } else {
            cache.put(i * 1000 + width_left, total + curHeight);
        }
        if (i == books.length) {
            ans = Math.min(ans, total + curHeight);
            return;
        }
        if (books[i][0] <= width_left) {
            if (books[i][1] <= curHeight) {
                dfs(books, i + 1, width_left - books[i][0], curHeight, total);
            } else {
                dfs(books, i + 1, width_left - books[i][0], books[i][1], total);
                dfs(books, i + 1, W - books[i][0], books[i][1], total + curHeight);
            }
        } else {
            dfs(books, i + 1, W - books[i][0], books[i][1], total + curHeight);
        }
    }
}