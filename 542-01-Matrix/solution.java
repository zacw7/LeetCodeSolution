class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return matrix;
        }
        int R = matrix.length, C = matrix[0].length;
        Queue<int[]> queue = new LinkedList();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 1) {
                    if ((r > 0 && matrix[r - 1][c] == 0)
                            || (r + 1 < R && matrix[r + 1][c] == 0)
                            || (c > 0 && matrix[r][c - 1] == 0)
                            || (c + 1 < C && matrix[r][c + 1] == 0)) {
                        queue.offer(new int[]{r, c});
                    } else {
                        matrix[r][c] = -1;
                    }
                }
            }
        }
        int dist = 2;
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int s = queue.size();
            while (s-- > 0) {
                int[] pos = queue.poll();
                for (int[] d : dir) {
                    int r = pos[0] + d[0], c = pos[1] + d[1];
                    if (r >= 0 && r < R && c >= 0 && c < C && matrix[r][c] < 0) {
                        matrix[r][c] = dist;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
}