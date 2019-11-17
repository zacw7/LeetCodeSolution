class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][] tmp;
        while (k-- > 0) {
            tmp = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == n - 1 && j == m - 1) {
                        tmp[0][0] = grid[i][j];
                    } else if (j == m - 1) {
                        tmp[i + 1][0] = grid[i][j];
                    } else {
                        tmp[i][j + 1] = grid[i][j];
                    }
                }
            }
            grid = tmp;
        }
        List<List<Integer>> res = new ArrayList();
        for (int[] g : grid) {
            List<Integer> row = new ArrayList();
            for (int num : g) {
                row.add(num);
            }
            res.add(row);
        }
        return res;
    }
}