class Solution {
    // Simulation
    // T: O(n)
    // S: O(1)
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int M = matrix.length, N = matrix[0].length;
        int i = 0, r = 0, c = 0;
        int[] order = new int[M * N];
        int direction = 1; // 1 for up, -1 for down
        boolean crossed = false;
        while (i < order.length) {
            if (r >= 0 && r < M && c >= 0 && c < N) {
                crossed = true;
                order[i++] = matrix[r][c];
            } else if (crossed) {
                if (r < 0 || r >= M) {
                    c++;
                } else {
                    r++;
                }
                direction = -direction;
                crossed = false;
            }
            r -= direction;
            c += direction;
        }
        return order;
    }
}