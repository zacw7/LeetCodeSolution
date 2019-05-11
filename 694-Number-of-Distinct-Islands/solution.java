class Solution {
    int R, C;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        R = grid.length;
        C = grid[0].length;
        Set<String> islands = new HashSet();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    islands.add(formatIsland(grid, r, c));
                }
            }
        }
        return islands.size();
    }

    private String formatIsland(int[][] grid, int r, int c) {
        StringBuilder sb = new StringBuilder("#");
        grid[r][c] = 0;
        for (int[] d : directions) {
            formatHelper(grid, r + d[0], c + d[1], d[0], d[1], sb);
        }
        return sb.toString();
    }

    private void formatHelper(int[][] grid, int r, int c, int dr, int dc, StringBuilder sb) {
        if (r < 0 || r >= R || c < 0 || c >= C || grid[r][c] == 0) {
            return;
        }

        sb.append(dr + "," + dc + "#");
        grid[r][c] = 0;

        for (int[] d : directions) {
            formatHelper(grid, r + d[0], c + d[1], dr + d[0], dc + d[1], sb);
        }
    }
}