class Solution {
    // T: O(mn)
    // S: O(m+n)
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int R = grid.length, C = grid[0].length;
        int[] verticalMax = new int[R], horizontalMax = new int[C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                verticalMax[r] = Math.max(verticalMax[r], grid[r][c]);
                horizontalMax[c] = Math.max(horizontalMax[c], grid[r][c]);
            }
        }

        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                count += Math.min(verticalMax[r], horizontalMax[c]) - grid[r][c];
            }
        }

        return count;
    }
}