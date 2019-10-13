class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList();
        int N = 64;
        boolean[][] queen = new boolean[N][N];
        for (int[] q : queens) {
            queen[q[0]][q[1]] = true;
        }
        int x = king[0], y = king[1];
        // up
        for (int r = x - 1, c = y; r >= 0; r--) {
            if (queen[r][c] == true) {
                List<Integer> pos = new ArrayList();
                pos.add(r);
                pos.add(c);
                res.add(pos);
                break;
            }
        }
        // down
        for (int r = x + 1, c = y; r < N; r++) {
            if (queen[r][c] == true) {
                List<Integer> pos = new ArrayList();
                pos.add(r);
                pos.add(c);
                res.add(pos);
                break;
            }
        }
        // left
        for (int r = x, c = y - 1; c >= 0; c--) {
            if (queen[r][c] == true) {
                List<Integer> pos = new ArrayList();
                pos.add(r);
                pos.add(c);
                res.add(pos);
                break;
            }
        }
        // right
        for (int r = x, c = y + 1; c < N; c++) {
            if (queen[r][c] == true) {
                List<Integer> pos = new ArrayList();
                pos.add(r);
                pos.add(c);
                res.add(pos);
                break;
            }
        }
        // up-left
        for (int r = x - 1, c = y - 1; r >= 0 && c >= 0; r--, c--) {
            if (queen[r][c] == true) {
                List<Integer> pos = new ArrayList();
                pos.add(r);
                pos.add(c);
                res.add(pos);
                break;
            }
        }
        // up-right
        for (int r = x - 1, c = y + 1; r >= 0 && c < N; r--, c++) {
            if (queen[r][c] == true) {
                List<Integer> pos = new ArrayList();
                pos.add(r);
                pos.add(c);
                res.add(pos);
                break;
            }
        }
        // bottan-left
        for (int r = x + 1, c = y - 1; r < N && c >= 0; r++, c--) {
            if (queen[r][c] == true) {
                List<Integer> pos = new ArrayList();
                pos.add(r);
                pos.add(c);
                res.add(pos);
                break;
            }
        }
        // bottan-right
        for (int r = x + 1, c = y + 1; r < N && c < N; r++, c++) {
            if (queen[r][c] == true) {
                List<Integer> pos = new ArrayList();
                pos.add(r);
                pos.add(c);
                res.add(pos);
                break;
            }
        }
        return res;
    }
}