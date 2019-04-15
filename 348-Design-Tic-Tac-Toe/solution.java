class TicTacToe {

    int[][] board;
    int winner, N;
    int[] rows, cols, diags;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.N = n;
        this.winner = 0;
        this.board = new int[N][N];
        this.rows = new int[N];
        this.cols = new int[N];
        this.diags = new int[2];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (winner != 0) {
            return (winner == -1) ? 2 : winner;
        }
        int p = (player == 1) ? 1 : -1;
        board[row][col] = p;
        rows[row] += p;
        cols[col] += p;
        if (row == col) {
            diags[0] += p;
            if (diags[0] == N || diags[0] == -N) {
                winner = diags[0] / N;
            }
        }
        if (row + col + 1 == N) {
            diags[1] += p;
            if (diags[1] == N || diags[1] == -N) {
                winner = diags[1] / N;
            }
        }
        if (Math.abs(rows[row]) == N) {
            winner = rows[row] / N;
        }
        if (Math.abs(cols[col]) == N) {
            winner = cols[col] / N;
        }
        return (winner == -1) ? 2 : winner;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */