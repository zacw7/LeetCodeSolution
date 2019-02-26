class Solution {
    public int numRookCaptures(char[][] board) {
        int locX = -1, locY = -1;
        int captures = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    locX = i;
                    locY = j;
                    break;
                }
            }
            if (locX >= 0) break;
        }
        // up
        for (int x = locX, y = locY - 1; y >= 0; y--) {
            if (board[x][y] == '.') {
                continue;
            } else if (board[x][y] == 'p') {
                captures++;
            }
            break;
        }
        // down
        for (int x = locX, y = locY + 1; y < board.length; y++) {
            if (board[x][y] == '.') {
                continue;
            } else if (board[x][y] == 'p') {
                captures++;
            }
            break;
        }
        // left
        for (int x = locX - 1, y = locY; x >= 0; x--) {
            if (board[x][y] == '.') {
                continue;
            } else if (board[x][y] == 'p') {
                captures++;
            }
            break;
        }
        // right
        for (int x = locX + 1, y = locY; x < board[0].length; x++) {
            if (board[x][y] == '.') {
                continue;
            } else if (board[x][y] == 'p') {
                captures++;
            }
            break;
        }
        return captures;
    }
}