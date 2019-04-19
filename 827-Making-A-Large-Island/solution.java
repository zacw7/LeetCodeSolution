class Solution {
    // T: O(n)
    // S: O(n)
    private int R, C;
    public int largestIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        R = grid.length;
        C = grid[0].length;
        Map<Integer, Integer> areaMap = new HashMap();
        int id = 2;
        int maxArea = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    int area = flagIslandHelper(grid, r, c, id);
                    areaMap.put(id++, area);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 0) {
                    int area = 1;
                    Set<Integer> islands = new HashSet();
                    if (r > 0 && areaMap.containsKey(grid[r - 1][c]) && !islands.contains(grid[r - 1][c])) {
                        area += areaMap.get(grid[r - 1][c]);
                        islands.add(grid[r - 1][c]);
                    }
                    if (r + 1 < R && areaMap.containsKey(grid[r + 1][c]) && !islands.contains(grid[r + 1][c])) {
                        area += areaMap.get(grid[r + 1][c]);
                        islands.add(grid[r + 1][c]);
                    }
                    if (c > 0 && areaMap.containsKey(grid[r][c - 1]) && !islands.contains(grid[r][c - 1])) {
                        area += areaMap.get(grid[r][c - 1]);
                        islands.add(grid[r][c - 1]);
                    }
                    if (c + 1 < C && areaMap.containsKey(grid[r][c + 1]) && !islands.contains(grid[r][c + 1])) {
                        area += areaMap.get(grid[r][c + 1]);
                        islands.add(grid[r][c + 1]);
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int flagIslandHelper(int[][] grid, int r, int c, int id) {
        grid[r][c] = id;
        int area = 1;
        if (r > 0 && grid[r - 1][c] == 1) {
            area += flagIslandHelper(grid, r - 1, c, id);
        }
        if (r + 1 < R && grid[r + 1][c] == 1) {
            area += flagIslandHelper(grid, r + 1, c, id);
        }
        if (c > 0 && grid[r][c - 1] == 1) {
            area += flagIslandHelper(grid, r, c - 1, id);
        }
        if (c + 1 < C && grid[r][c + 1] == 1) {
            area += flagIslandHelper(grid, r, c + 1, id);
        }
        return area;
    }
}