class Solution {
    public int minFallingPathSum(int[][] arr) {
        int R = arr.length, C = arr[0].length;
        int[] mins = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        int minSum = Integer.MAX_VALUE;
        for (int r = 0; r < R; r++) {
            int[] tmp = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
            for (int c = 0; c < C; c++) {
                if (r > 0) {
                    if (c == mins[0]) {
                        arr[r][c] += arr[r - 1][mins[1]];
                    } else {
                        arr[r][c] += arr[r - 1][mins[0]];
                    }
                }
                if (r == R - 1) {
                    minSum = Math.min(minSum, arr[r][c]);
                }
                if (tmp[0] == Integer.MAX_VALUE || arr[r][c] < arr[r][tmp[0]]) {
                    tmp[1] = tmp[0];
                    tmp[0] = c;
                } else if (tmp[1] == Integer.MAX_VALUE || arr[r][c] < arr[r][tmp[1]]) {
                    tmp[1] = c;
                }
            }
            mins = tmp;
        }
        return minSum;
    }
}