class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> ans = new ArrayList();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return ans;
        }
        int R = matrix.length, C = matrix[0].length;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] pacific = new boolean[R][C];
        Queue<Integer> queue = new LinkedList();
        for (int r = 0; r < R; r++) {
            dfs(matrix, r, 0, pacific);
            dfs(matrix, r, C - 1, atlantic);
        }
        for (int c = 0; c < C; c++) {
            dfs(matrix, 0, c, pacific);
            dfs(matrix, R - 1, c, atlantic);
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    ans.add(new int[]{r, c});
                }
            }
        }
        return ans;
    }
}