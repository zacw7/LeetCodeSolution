class Solution {
    public boolean validTicTacToe(String[] board) {
        char[][] tiles = new char[3][];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = board[i].toCharArray();
        }

        for (char[] row : tiles) {
            System.out.println(Arrays.toString(row));
        }

        int countX = 0, countO = 0;
        boolean X_win = false, O_win = false;
        int[] rows = new int[3], cols = new int[3], digs = new int[2];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (tiles[r][c] == ' ') continue;
                if (tiles[r][c] == 'X') {
                    rows[r]++;
                    cols[c]++;
                    if (r == c) digs[0]++;
                    if (r + c == 2) digs[1]++;
                    countX++;
                } else {
                    rows[r]--;
                    cols[c]--;
                    if (r == c) digs[0]--;
                    if (r + c == 2) digs[1]--;
                    countO++;
                }
            }
        }

        if (countX < countO || countX > countO + 1) {
            return false;
        }

        for (int r : rows) {
            if (r == 3) X_win = true;
            else if (r == -3) O_win = true;
        }
        for (int c : cols) {
            if (c == 3) X_win = true;
            else if (c == -3) O_win = true;
        }
        for (int d : digs) {
            if (d == 3) X_win = true;
            else if (d == -3) O_win = true;
        }

        if (X_win && O_win) return false;
        if (X_win && countX == countO) return false;
        if (O_win && countX > countO) return false;
        return true;
    }
}