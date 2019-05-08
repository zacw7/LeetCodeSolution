class Solution {
    // LTE
    // Time: O(k*mn)
    // Space: O(mn)
    int[][] DIRECTIONS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        List<Integer> nums = new ArrayList();
        int cur = 0, id = 1;
        for (int[] p : positions) {
            int r = p[0], c = p[1];
            if (grid[r][c] != 0) {
                nums.add(cur);
                continue;
            }
            grid[r][c] = id;
            if (cur == 0) {
                cur = 1;
            } else {
                Set<Integer> adjIsland = new HashSet();
                for (int[] DIR : DIRECTIONS) {
                    int x = r + DIR[0], y = c + DIR[1];
                    if (x >= 0 && x  < m && y >= 0 && y < n && grid[x][y] != 0) {
                        adjIsland.add(grid[x][y]);
                    }
                }
                for (int[] DIR : DIRECTIONS) {
                    int x = r + DIR[0], y = c + DIR[1];
                    if (x >= 0 && x  < m && y >= 0 && y < n && grid[x][y] != 0) {
                        transform(grid, x, y, id);
                    }
                }
                if (!adjIsland.isEmpty()) {
                    cur -= adjIsland.size() - 1;
                } else {
                    cur++;
                }
            }
            nums.add(cur);
            id++;
        }
        return nums;
    }

    private void transform(int[][] grid, int r, int c, int id) {
        grid[r][c] = -grid[r][c];   // visited
        for (int[] DIR : DIRECTIONS) {
            int x = r + DIR[0], y = c + DIR[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length && grid[x][y] == -grid[r][c]) {
                transform(grid, x, y, id);
            }
        }
        grid[r][c] = id;
    }
}