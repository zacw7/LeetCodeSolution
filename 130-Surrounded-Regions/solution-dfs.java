class Solution {
    // dfs
    int R, C;
    int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        R = board.length;
        C = board[0].length;
        for (int r = 0; r < R; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if (board[r][C - 1] == 'O') {
                dfs(board, r, C - 1);
            }
        }
        for (int c = 1; c < C - 1; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if (board[R - 1][c] == 'O') {
                dfs(board, R - 1, c);
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'F') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r0, int c0) {
        board[r0][c0] = 'F';
        for (int[] d : dir) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && r < R && c >= 0 && c < C && board[r][c] == 'O') {
                dfs(board, r, c);
            }
        }
    }
}