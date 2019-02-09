class Solution {
    public boolean isValidSudoku(char[][] board) {
        // validate rows
        for (int i = 0; i < 9; i++) {
            Set<Character> digitSet = new HashSet();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (digitSet.contains(board[i][j])) {
                    return false;
                } else {
                    digitSet.add(board[i][j]);
                }
            }
        }
        // validate columns
        for (int j = 0; j < 9; j++) {
            Set<Character> digitSet = new HashSet();
            for (int i = 0; i < 9; i++) {
                if (board[i][j] == '.') continue;
                if (digitSet.contains(board[i][j])) {
                    return false;
                } else {
                    digitSet.add(board[i][j]);
                }
            }
        }
        // validate sub-boxes
        for (int offSetR = 0; offSetR < 3; offSetR++) {
            for (int offSetC = 0; offSetC < 3; offSetC++) {
                Set<Character> digitSet = new HashSet();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int indexR = i + 3 * offSetR, indexC = j + 3 * offSetC;
                        if (board[indexR][indexC] == '.') continue;
                        if (digitSet.contains(board[indexR][indexC])) {
                            return false;
                        } else {
                            digitSet.add(board[indexR][indexC]);
                        }
                    }
                }
            }
        }
        return true;
    }
}