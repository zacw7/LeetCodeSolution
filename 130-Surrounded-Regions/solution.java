class Solution {
    int R, C;
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        R = board.length;
        C = board[0].length;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'O') {
                    if (r == 0 || r == R - 1 || c == 0 || c == C - 1)
                        flip(board, r, c);
                }
            }
        }
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                if (board[r][c] == 'F') board[r][c] = 'O';
            }
        }
    }

    private void flip(char[][] board, int r, int c) {
        board[r][c] = 'F';
        if (r > 0 && board[r - 1][c] == 'O') flip(board, r - 1, c);
        if (c > 0 && board[r][c - 1] == 'O') flip(board, r, c - 1);
        if (r < R - 1 && board[r + 1][c] == 'O') flip(board, r + 1, c);
        if (c < C - 1 && board[r][c + 1] == 'O') flip(board, r, c + 1);
    }
}