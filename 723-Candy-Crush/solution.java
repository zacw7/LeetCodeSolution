class Solution {
    // Simulation
    // Time: O((R*C)^2)
    // Space: O(1)
    int R, C;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return board;
        }
        R = board.length;
        C = board[0].length;
        boolean stable = false;
        while (!stable) {
            stable = true;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    // check horizontal
                    if (c + 2 < C && board[r][c] != 0
                            && Math.abs(board[r][c]) == Math.abs(board[r][c + 1])
                            && Math.abs(board[r][c]) == Math.abs(board[r][c + 2])) {
                        board[r][c] = board[r][c + 1] = board[r][c + 2] = -Math.abs(board[r][c]);
                        stable = false;
                    }
                    // check vertical
                    if (r + 2 < R && board[r][c] != 0
                            && Math.abs(board[r][c]) == Math.abs(board[r + 1][c])
                            && Math.abs(board[r][c]) == Math.abs(board[r + 2][c])) {
                        board[r][c] = board[r + 1][c] = board[r + 2][c] = -Math.abs(board[r][c]);
                        stable = false;
                    }
                }
            }
            if (!stable) {
                for (int c = 0; c < C; c++) {
                    fall(board, c);
                }
            }
        }
        return board;
    }

    private void fall(int[][] board, int c) {
        for (int r = 0; r < R; r++) {
            if (board[r][c] < 0) {
                board[r][c] = 0;
            }
        }
        int lo = R - 1;
        while (lo >= 0) {
            if (board[lo][c] == 0) {
                int hi = lo - 1;
                while (hi >= 0 && board[hi][c] == 0) {
                    hi--;
                }
                if (hi < 0) {
                    break;
                }
                board[lo][c] = board[hi][c];
                board[hi][c] = 0;
            }
            lo--;
        }
    }
}