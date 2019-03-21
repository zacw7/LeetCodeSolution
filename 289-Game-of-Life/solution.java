class Solution {
    public void gameOfLife(int[][] board) {
        int length = board.length, width = board[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int neighbors = 0;
                if (i > 0 && j > 0 && board[i - 1][j - 1] > 0) neighbors++;
                if (i > 0 && board[i - 1][j] > 0) neighbors++;
                if (i > 0 && j < width - 1 && board[i -1][j + 1] > 0) neighbors++;
                if (j > 0 && board[i][j - 1] > 0) neighbors++;
                if (j < width - 1 && board[i][j + 1] > 0) neighbors++;
                if (i < length - 1 && j > 0 && board[i + 1][j - 1] > 0) neighbors++;
                if (i < length - 1 && board[i + 1][j] > 0) neighbors++;
                if (i < length - 1 && j < width - 1 && board[i + 1][j + 1] > 0) neighbors++;
                if (board[i][j] == 1) {
                    if (neighbors > 0) board[i][j] = neighbors;
                    else board[i][j] = 10;
                } else {
                    board[i][j] = -neighbors;
                }
            }
        }
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 2 || board[i][j] == 3 || board[i][j] == -3) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }
    }
}