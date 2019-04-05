class Solution {
    int N = 9;
    boolean[][] rows = new boolean[N][N];
    boolean[][] columns = new boolean[N][N];
    boolean[][][] boxes = new boolean[3][3][N];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') continue;
                int digit = board[i][j] - '1';
                rows[i][digit] = true;
                columns[j][digit] = true;
                boxes[i / 3][j / 3][digit] = true;
            }
        }
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int i) {
        if (i == N * N) return true;
        int r = i / N, c = i % N;
        if (board[r][c] != '.') {
            return dfs(board, i + 1);
        } else {
            for (int n = 0; n < N; n++) {
                if (!rows[r][n] && !columns[c][n]
                        && !boxes[r / 3][c / 3][n]) {
                    rows[r][n] = true;
                    columns[c][n] = true;
                    boxes[r / 3][c / 3][n] = true;
                    board[r][c] = (char)('1' + n);
                    if (dfs(board, i + 1)) return true;
                    board[r][c] = '.';
                    rows[r][n] = false;
                    columns[c][n] = false;
                    boxes[r / 3][c / 3][n] = false;
                }
            }
            return false;
        }
    }
}