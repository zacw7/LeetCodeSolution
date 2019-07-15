class Solution {
    int R, C;
    int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return board;
        }
        R = board.length;
        C = board[0].length;
        int r = click[0], c = click[1];
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
        } else {
            updateBoard(board, r, c);
        }
        return board;
    }

    private void updateBoard(char[][] board, int r0, int c0) {
        int bombs = adjBombs(board, r0, c0);
        if (bombs == 0) {
            board[r0][c0] = 'B';
            for (int[] d : dir) {
                int r = r0 + d[0], c = c0 + d[1];
                if (r >= 0 && r < R && c >= 0 && c < C && board[r][c] == 'E') {
                    updateBoard(board, r, c);
                }
            }
        } else {
            board[r0][c0] = (char) ('0' + bombs);
        }
    }

    private int adjBombs(char[][] board, int r0, int c0) {
        int count = 0;
        for (int[] d : dir) {
            int r = r0 + d[0], c = c0 + d[1];
            if (r >= 0 && r < R && c >= 0 && c < C && board[r][c] == 'M') {
                count++;
            }
        }
        return count;
    }
}