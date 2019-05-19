class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int m : machines) {
            sum += m;
        }
        if (sum % machines.length > 0) {
            return -1;
        }
        int moves = 0, avg = sum / machines.length;
        int toLeft = 0, toRight = 0;
        for (int m : machines) {
            toRight = m - avg - toLeft;
            moves = Math.max(moves, toLeft);
            moves = Math.max(moves, toRight);
            moves = Math.max(moves, toLeft + toRight);
            toLeft = -toRight;
        }
        return moves;
    }
}