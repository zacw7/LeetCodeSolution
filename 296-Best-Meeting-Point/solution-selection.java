class Solution {
    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int R = grid.length, C = grid[0].length;
        List<Integer> rows = new ArrayList();
        List<Integer> cols = new ArrayList();

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    rows.add(r);
                }
            }
        }

        for (int c = 0; c < C; c++) {
            for (int r = 0; r < R; r++) {
                if (grid[r][c] == 1) {
                    cols.add(c);
                }
            }
        }

        int midR = rows.get(rows.size() / 2);
        int midC = cols.get(cols.size() / 2);

        return minDistance(rows, midR) + minDistance(cols, midC);
    }

    private int minDistance(List<Integer> positions, int x) {
        int dist = 0;
        for (int pos : positions) {
            dist += Math.abs(pos - x);
        }
        return dist;
    }
}