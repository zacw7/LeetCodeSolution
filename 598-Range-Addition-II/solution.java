class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m, col = n;
        for (int[] op : ops) {
            if (op[0] < row) row = op[0];
            if (op[1] < col) col = op[1];
        }
        return row * col;
    }
}