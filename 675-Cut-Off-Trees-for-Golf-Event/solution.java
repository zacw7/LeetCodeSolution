class Solution {
    int R, C;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        R = forest.size();
        C = forest.get(0).size();
        List<int[]> treeList = new ArrayList();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (forest.get(r).get(c) > 0) {
                    treeList.add(new int[]{r, c});
                }
            }
        }
        Collections.sort(treeList, (a, b) -> forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1]));
        if (treeList.isEmpty()) {
            return 0;
        }
        int steps = 0;
        int[] cur = new int[]{0, 0};
        for (int i = 0; i < treeList.size(); i++) {
            int[] next = treeList.get(i);
            int dist = getDist(forest, cur, treeList.get(i));
            cur = next;
            if (dist == -1) {
                steps = -1;
                break;
            } else {
                steps += dist;
            }
        }
        return steps;
    }

    private int getDist(List<List<Integer>> forest, int[] cur, int[] next) {
        if (cur[0] == next[0] && cur[1] == next[1]) {
            return 0;
        }
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new LinkedList();
        queue.offer(cur);
        visited[cur[0]][cur[1]] = true;
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] pos = queue.poll();
                for (int[] d : dirs) {
                    int r = pos[0] + d[0], c = pos[1] + d[1];
                    if (r >= 0 && c >= 0 && r < R && c < C && !visited[r][c] && forest.get(r).get(c) > 0) {
                        if (r == next[0] && c == next[1]) {
                            return dist;
                        } else {
                            queue.offer(new int[]{r, c});
                            visited[r][c] = true;
                        }
                    }
                }
            }
            dist++;
        }
        return -1;
    }
}