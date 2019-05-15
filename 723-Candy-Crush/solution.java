class Solution {
    // Simulation
    // Time: O((R*C)^2)
    // Space: O(1)
    public int[][] candyCrush(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return board;
        }
        int R = board.length, C = board[0].length;
        boolean stable = false;
        while (!stable) {
            stable = true;
            // flag
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (board[r][c] == 0) {
                        continue;
                    }
                    if (c + 2 < C && Math.abs(board[r][c]) == Math.abs(board[r][c + 1])
                            && Math.abs(board[r][c]) == Math.abs(board[r][c + 2])) {
                        board[r][c] = board[r][c + 1] = board[r][c + 2] = -Math.abs(board[r][c]);
                        stable = false;
                    }
                    if (r + 2 < R && Math.abs(board[r][c]) == Math.abs(board[r + 1][c])
                            && Math.abs(board[r][c]) == Math.abs(board[r + 2][c])) {
                        board[r][c] = board[r + 1][c] = board[r + 2][c] = -Math.abs(board[r][c]);
                        stable = false;
                    }
                }
            }
            if (!stable) {
                // eliminate
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (board[r][c] < 0) {
                            board[r][c] = 0;
                        }
                    }
                }
                // gravity
                for (int c = 0; c < C; c++) {
                    int lo = R - 1;
                    while (lo >= 0) {
                        if (board[lo][c] == 0) {
                            int hi = lo - 1;
                            while (hi >= 0 && board[hi][c] == 0) {
                                hi--;
                            }
                            if (hi >= 0) {
                                board[lo][c] = board[hi][c];
                                board[hi][c] = 0;
                            } else {
                                break;
                            }
                        } else {
                            lo--;
                        }
                    }
                }
            }
        }
        return board;
    }
}