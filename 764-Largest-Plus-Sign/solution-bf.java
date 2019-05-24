class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for (int[] row : grid) {
            Arrays.fill(row, 1);
        }
        for (int[] m : mines) {
            grid[m[0]][m[1]] = 0;
        }
        int max = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) {
                    int up = 1, down = 1, left = 1, right = 1;
                    for (int i = r - 1; i >= 0 && grid[i][c] == 1; i--) {
                        up++;
                    }
                    for (int i = r + 1; i < N && grid[i][c] == 1; i++) {
                        down++;
                    }
                    for (int i = c - 1; i >= 0 && grid[r][i] == 1; i--) {
                        left++;
                    }
                    for (int i = c + 1; i < N && grid[r][i] == 1; i++) {
                        right++;
                    }
                    max = Math.max(max, Math.min(Math.min(up, down), Math.min(left, right)));
                }
            }
        }
        return max;
    }
}