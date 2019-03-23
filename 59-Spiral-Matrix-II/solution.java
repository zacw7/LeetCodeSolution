class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;
        int MAX_LAYER = (n - 1) / 2;
        int c = 1;
        for (int layer = 0; layer <= MAX_LAYER; layer++) {
            res[layer][layer] = c++;
            for (int col = layer + 1; col <= n - layer - 1; col++) res[layer][col] = c++;
            for (int row = layer + 1; row <= n - layer - 1; row++) res[row][n - layer - 1] = c++;
            for (int col = n - layer - 2; col >= layer; col--) res[n - layer - 1][col] = c++;
            for (int row = n - layer - 2; row > layer; row--) res[row][layer] = c++;
        }
        return res;
    }
}