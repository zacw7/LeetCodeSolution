class Solution {
    List<List<String>> res = new ArrayList();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        if (n > 0) helper(board, 0, n);
        return res;
    }

    private void helper(char[][] board, int r, int N) {
        if (r >= N) {
            List<String> solution = new ArrayList();
            for (char[] row : board) solution.add(new String(row));
            res.add(solution);
        } else {
            for (int i = 0; i < N; i++) {
                if (isValid(board, r, i, N)) {
                    board[r][i] = 'Q';
                    helper(board, r + 1, N);
                    board[r][i] = '.';
                }
            }
        }
    }

    private boolean isValid(char[][] board, int r, int c, int N) {
        if (r == 0) return true;
        // check column
        for (int i = 0; i < r; i++) {
            if (board[i][c] == 'Q') return false;
        }
        // check diagonal
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}