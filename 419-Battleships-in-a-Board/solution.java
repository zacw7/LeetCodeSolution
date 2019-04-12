class Solution {
    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return 0;
        int R = board.length, C = board[0].length;
        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 'X') {
                    if (r > 0 && board[r - 1][c] == 'X') continue;
                    if (c > 0 && board[r][c - 1] == 'X') continue;
                    count++;
                }
            }
        }
        return count++;
    }
}