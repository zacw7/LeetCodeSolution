class Solution {
    int R, C;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList();
        if (matrix.length == 0 || matrix[0].length == 0) return ans;
        R = matrix.length;
        C = matrix[0].length;
        boolean[][] pacific = new boolean[R][C];
        for (int c = 0; c < C; c++) dfs(matrix, pacific, 0, c);
        for (int r = 1; r < R; r++) dfs(matrix, pacific, r, 0);
        boolean[][] atlantic = new boolean[R][C];
        for (int c = C - 1; c >= 0; c--) dfs(matrix, atlantic, R - 1, c);
        for (int r = R - 1; r >= 0; r--) dfs(matrix, atlantic, r, C - 1);
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    ans.add(new int[]{r, c});
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix,boolean[][] cell, int r, int c) {
        if (cell[r][c]) return;
        cell[r][c] = true;
        if (r > 0 && matrix[r - 1][c] >= matrix[r][c]) dfs(matrix, cell, r - 1, c);
        if (c > 0 && matrix[r][c - 1] >= matrix[r][c]) dfs(matrix, cell, r, c - 1);
        if (r < R - 1 && matrix[r + 1][c] >= matrix[r][c]) dfs(matrix, cell, r + 1, c);
        if (c < C - 1 && matrix[r][c + 1] >= matrix[r][c]) dfs(matrix, cell, r, c + 1);
    }
}