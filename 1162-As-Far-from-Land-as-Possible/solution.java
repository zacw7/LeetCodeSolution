class Solution {
    public int maxDistance(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> queue = new LinkedList();
        boolean noWater = true, noLand = true;;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == 1) {
                    queue.offer(r * C + c);
                } else {
                    noWater = false;
                }
            }
        }
        if (noWater || queue.isEmpty()) {
            return -1;
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            while (size-- > 0) {
                int pos = queue.poll();
                for (int[] d : dirs) {
                    int r = pos / C + d[0], c = pos % C + d[1];
                    if (r >= 0 && c >= 0 && r < R && c < C && grid[r][c] == 0) {
                        queue.offer(r * C + c);
                        grid[r][c] = dist;
                    }
                }
            }
        }
        return dist - 1;
    }
}