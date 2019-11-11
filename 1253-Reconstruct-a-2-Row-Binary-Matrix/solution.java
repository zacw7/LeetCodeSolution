class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int N = colsum.length;
        int[] upperRow = new int[N];
        int[] lowerRow = new int[N];
        List<List<Integer>> res = new ArrayList();
        if (dfs(upper, lower, colsum, 0, upperRow, lowerRow)) {
            res.add(new ArrayList());
            res.add(new ArrayList());
            for (int i = 0; i < N; i++) {
                res.get(0).add(upperRow[i]);
                res.get(1).add(lowerRow[i]);
            }
        }
        return res;
    }

    private boolean dfs(int upper, int lower, int[] colsum, int i, int[] upperRow, int[] lowerRow) {
        if (i == colsum.length) {
            if (upper == 0 && lower == 0) {
                return true;
            }
        } else if (colsum[i] == 0) {
            upperRow[i] = 0;
            lowerRow[i] = 0;
            return dfs(upper, lower, colsum, i + 1, upperRow, lowerRow);
        } else if (colsum[i] == 2) {
            upperRow[i] = 1;
            lowerRow[i] = 1;
            return dfs(upper - 1, lower - 1, colsum, i + 1, upperRow, lowerRow);
        } else if (colsum[i] == 1) {
            if (upper > lower) {
                upperRow[i] = 1;
                lowerRow[i] = 0;
                return dfs(upper - 1, lower, colsum, i + 1, upperRow, lowerRow);
            } else if (lower > upper) {
                upperRow[i] = 0;
                lowerRow[i] = 1;
                return dfs(upper, lower - 1, colsum, i + 1, upperRow, lowerRow);
            } else if (upper > 0) {
                upperRow[i] = 1;
                lowerRow[i] = 0;
                return dfs(upper - 1, lower, colsum, i + 1, upperRow, lowerRow);
            }
        }
        return false;
    }
}