class Solution {
    int R, C;
    public int numEnclaves(int[][] A) {
        if (A.length == 0 || A[0].length == 0) return 0;
        R = A.length;
        C = A[0].length;
        for (int r = 0; r < R; r++) {
            if (A[r][0] == 1) dfs(A, r, 0);
            if (A[r][C - 1] == 1) dfs(A, r, C - 1);
        }
        for (int c = 0; c < C; c++) {
            if (A[0][c] == 1) dfs(A, 0, c);
            if (A[R - 1][c] == 1) dfs(A, R - 1, c);
        }
        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] == 1) count++;
            }
        }
        return count;
    }

    private void dfs(int[][] A, int r, int c) {
        A[r][c] = 0;
        if (r > 0 && A[r - 1][c] == 1) dfs(A, r - 1, c);
        if (r < R - 1 && A[r + 1][c] == 1) dfs(A, r + 1, c);
        if (c > 0 && A[r][c - 1] == 1) dfs(A, r, c - 1);
        if (c < C - 1 && A[r][c + 1] == 1) dfs(A, r, c + 1);
    }
}