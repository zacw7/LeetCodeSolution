class Solution {
    public int maximumMinimumPath(int[][] A) {
        int R = A.length, C = A[0].length;
        if (R == 1 && C == 1) {
            return A[0][0];
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        PriorityQueue<Integer> queue
                = new PriorityQueue<Integer>((a, b) -> A[b / 100][b % 100] - A[a / 100][a % 100]);
        boolean[][] visited = new boolean[R][C];
        queue.offer(0);
        visited[0][0] = true;
        int value = A[0][0];
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            value = Math.min(value, A[pos / 100][pos % 100]);
            for (int[] d : dir) {
                int r = pos / 100 + d[0], c = pos % 100 + d[1];
                if (r >= 0 && r < R && c >= 0 && c < C && !visited[r][c]) {
                    visited[r][c] = true;
                    if (r == R - 1 && c == C - 1) {
                        return Math.min(value, A[r][c]);
                    }
                    queue.offer(r * 100 + c);
                }
            }
        }
        return 0;
    }
}