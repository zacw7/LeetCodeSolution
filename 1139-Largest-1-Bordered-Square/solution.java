class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] left = new int[R][C];
        int[][] up = new int[R][C];
        int max = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    left[r][c] = up[r][c] = 1;
                    if (r > 0) {
                        up[r][c] += up[r - 1][c];
                    }
                    if (c > 0) {
                        left[r][c] += left[r][c - 1];
                    }
                    for (int t = Math.min(left[r][c], up[r][c]); t > 0; t--) {
                        if (up[r][c - t + 1] >= t && left[r - t + 1][c] >= t) {
                            max = Math.max(max, t * t);
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }
}