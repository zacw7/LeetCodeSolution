class Solution {
    int R, C;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int shortestBridge(int[][] A) {
        R = A.length;
        C = A[0].length;
        boolean[][] visited = new boolean[R][C];
        Queue<Integer> queue = new LinkedList();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (A[r][c] == 1) {
                    dfs(A, r, c, queue, visited);
                    break;
                }
            }
            if (!queue.isEmpty()) {
                break;
            }
        }
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int r = pos / C, c = pos % C;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
                    if (A[nr][nc] == 0) {
                        A[nr][nc] = A[r][c] + 1;
                    } else if (A[nr][nc] == 1 && A[r][c] > 1) {
                        return A[r][c] - 1;
                    }
                    visited[nr][nc] = true;
                    queue.offer(nr * C + nc);
                }
            }
        }
        return 0;
    }

    private void dfs(int[][] A, int r, int c, Queue<Integer> queue, boolean[][] visited) {
        queue.offer(r * C + c);
        visited[r][c] = true;
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && A[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(A, nr, nc, queue, visited);
            }
        }
    }
}