class Solution {
    public int minimumMoves(int[][] grid) {
        int N = grid.length;
        Set<String> seen = new HashSet();
        int[] start = new int[]{0, 0, 0, 1};
        int[] end = new int[]{N - 1, N - 2, N - 1, N - 1};
        String startStr = Arrays.toString(start);
        String endStr = Arrays.toString(end);
        Queue<int[]> queue = new LinkedList();
        queue.offer(start);
        seen.add(startStr);
        int move = 0;
        while (!queue.isEmpty()) {
            // System.out.println(queue.toString());
            move++;
            int sz = queue.size();
            while (sz-- > 0) {
                int[] cur = queue.poll();
                // System.out.println(Arrays.toString(cur));
                int r1 = cur[0], c1 = cur[1], r2 = cur[2], c2 = cur[3];
                // move right
                int x1, y1, x2, y2;
                x1 = r1;
                x2 = r2;
                y1 = c1 + 1;
                y2 = c2 + 1;
                if (x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0
                        && x1 < N && x2 < N && y1 < N && y2 < N
                        && grid[x1][y1] == 0 && grid[x2][y2] == 0) {
                    int[] neigh = new int[]{x1, y1, x2, y2};
                    String key = Arrays.toString(neigh);
                    // System.out.println("right: " + key);
                    if (!seen.contains(key)) {
                        seen.add(key);
                        queue.offer(neigh);
                    }
                }
                // move down
                x1 = r1 + 1;
                x2 = r2 + 1;
                y1 = c1;
                y2 = c2;
                if (x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0
                        && x1 < N && x2 < N && y1 < N && y2 < N
                        && grid[x1][y1] == 0 && grid[x2][y2] == 0) {
                    int[] neigh = new int[]{x1, y1, x2, y2};
                    String key = Arrays.toString(neigh);
                    // System.out.println("down: " + key);
                    if (!seen.contains(key)) {
                        seen.add(key);
                        queue.offer(neigh);
                    }
                }
                // clockwise
                if (r1 == r2 && r1 + 1 < N && grid[r1 + 1][c1] == 0 && grid[r1 + 1][c2] == 0) {
                    x1 = r1;
                    y1 = c1;
                    x2 = r1 + 1;
                    y2 = y1;
                    if (x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0
                            && x1 < N && x2 < N && y1 < N && y2 < N) {
                        int[] neigh = new int[]{x1, y1, x2, y2};
                        String key = Arrays.toString(neigh);
                        // System.out.println("clockwise: " + key);
                        if (!seen.contains(key)) {
                            seen.add(key);
                            queue.offer(neigh);
                        }
                    }
                }
                // counterclockwise
                if (c1 == c2 && c1 + 1 < N && grid[r1][c1 + 1] == 0 && grid[r2][c2 + 1] == 0) {
                    x1 = r1;
                    y1 = c1;
                    x2 = r1;
                    y2 = c1 + 1;
                    if (x1 >= 0 && x2 >= 0 && y1 >= 0 && y2 >= 0
                            && x1 < N && x2 < N && y1 < N && y2 < N) {
                        int[] neigh = new int[]{x1, y1, x2, y2};
                        String key = Arrays.toString(neigh);
                        // System.out.println("counterclockwise: " + key);
                        if (!seen.contains(key)) {
                            seen.add(key);
                            queue.offer(neigh);
                        }
                    }
                }
            }
            if (seen.contains(endStr)) {
                return move;
            }
        }
        return -1;
    }
}