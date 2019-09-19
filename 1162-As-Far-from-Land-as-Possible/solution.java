class Solution {
    public int maxDistance(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> queue = new LinkedList();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    queue.offer(r * C + c);
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            while (sz-- > 0) {
                int cur = queue.poll();
                for (int[] d : dirs) {
                    int r = cur / C + d[0], c = cur % C + d[1];
                    if (r >= 0 && c >= 0 && r < R && c < C && grid[r][c] == 0) {
                        grid[r][c] = 1;
                        queue.offer(r * C + c);
                    }
                }
            }
            if (queue.isEmpty()) {
                break;
            } else {
                dist++;
            }
        }
        return dist <= 0 ? -1 : dist;
    }
}