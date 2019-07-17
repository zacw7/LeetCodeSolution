class Solution {
    int R, C;
    boolean[][] visited;
    int[][] dp;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        R = matrix.length;
        C = matrix[0].length;
        visited = new boolean[R][C];
        dp = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!visited[r][c]) {
                    dfs(matrix, r, c);
                }
            }
        }
        int maxLen = 0;
        for (int[] d : dp) {
            for (int len : d) {
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    private int dfs(int[][] matrix, int r, int c) {
        if (dp[r][c] > 0) {
            return dp[r][c];
        }
        visited[r][c] = true;
        int len = 0;
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && matrix[nr][nc] > matrix[r][c] && !visited[nr][nc]) {
                len = Math.max(len, dfs(matrix, nr, nc));
            }
        }
        dp[r][c] = len + 1;
        visited[r][c] = false;
        return len + 1;
    }

}