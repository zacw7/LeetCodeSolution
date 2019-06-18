class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        if (grid[0][0] == 1 || grid[R - 1][C - 1] == 1) {
            return -1;
        }
        if (R == 1 && C == 1) {
            return 1;
        }
        Set<Integer> visited = new HashSet();
        Queue<Integer> queue = new LinkedList();
        if (grid[0][0] == 0) {
            visited.add(0);
            queue.offer(0);
        }
        int step = 1;
        int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            while (size-- > 0) {
                int pos = queue.poll();
                for (int[] d : dir) {
                    int r = pos / C + d[0], c = pos % C + d[1];
                    if (r >= 0 && r < R && c >= 0 && c < C && !visited.contains(r * C + c) && grid[r][c] == 0) {
                        if (r == R - 1 && c == C - 1) {
                            return step;
                        }
                        visited.add(r * C + c);
                        queue.offer(r * C + c);
                    }
                }
            }
        }
        return -1;
    }
}