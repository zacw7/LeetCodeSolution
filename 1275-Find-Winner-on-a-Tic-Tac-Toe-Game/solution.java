class Solution {
    public String tictactoe(int[][] moves) {
        char[][] grid = new char[3][3];
        for (char[] g : grid) {
            Arrays.fill(g, 'X');
        }
        for (int i = 0; i < moves.length; i++) {
            char c = 'A';
            if (i % 2 == 1) {
                c = 'B';
            }
            grid[moves[i][0]][moves[i][1]] = c;
            if (check(grid)) {
                return String.valueOf(c);
            }
        }
        if (moves.length == 9) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    private boolean check(char[][] grid) {
        for (int r = 0; r < 3; r++) {
            if (grid[r][0] != 'X' && grid[r][0] == grid[r][1] && grid[r][1] == grid[r][2]) {
                return true;
            }
        }
        for (int c = 0; c < 3; c++) {
            if (grid[0][c] != 'X' && grid[0][c] == grid[1][c] && grid[1][c] == grid[2][c]) {
                return true;
            }
        }
        return grid[1][1] != 'X' && ((grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
                || (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]));
    }
}