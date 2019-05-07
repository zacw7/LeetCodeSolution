class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int INF = Integer.MAX_VALUE;
        int[][] DIRECTIONS = new int[][]{
                {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        int R = rooms.length, C = rooms[0].length;
        Queue<int[]> queue = new LinkedList();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (rooms[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }

        int dist = 0;
        while (!queue.isEmpty()) {
            dist++;
            int s = queue.size();
            while (s-- > 0) {
                int[] pos = queue.poll();
                for (int[] d : DIRECTIONS) {
                    int r = pos[0] + d[0];
                    int c = pos[1] + d[1];
                    if (r >= 0 && r < R && c >= 0 && c < C && rooms[r][c] == INF) {
                        rooms[r][c] = dist;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }
    }
}