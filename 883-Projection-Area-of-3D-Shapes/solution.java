class Solution {
    public int projectionArea(int[][] grid) {
        int N = grid.length;
        int[] projX = new int[N];
        int[] projY = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) sum++;
                if (grid[i][j] > projX[i]) projX[i] = grid[i][j];
                if (grid[i][j] > projY[j]) projY[j] = grid[i][j];
            }
        }

        for (int n : projX) sum += n;
        for (int n : projY) sum += n;
        return sum;
    }
}