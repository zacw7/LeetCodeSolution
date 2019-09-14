class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int R = grid.length, C = grid[0].length();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int keyCount = 0;
        int startPoint = -1;
        Queue<Pair> queue = new LinkedList();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r].charAt(c) >= 'A' && grid[r].charAt(c) <= 'F') {
                    keyCount++;
                } else if (grid[r].charAt(c) == '@') {
                    startPoint = r * C + c;
                }
            }
        }
        int[][] dp = new int[1 << keyCount][R * C];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dp[0][startPoint] = 0;
        queue.offer(new Pair(0, startPoint));
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int[] d : dirs) {
                int r = cur.pos / C + d[0], c = cur.pos % C + d[1], neigh = r * C + c;
                if (r >= 0 && c >= 0 && r < R && c < C) {
                    char cell = grid[r].charAt(c);
                    if (cell == '#' || (cell >= 'A' && cell <= 'F' && (cur.state & (1 << (cell - 'A'))) == 0)) {
                        continue;
                    } else {
                        int state = cur.state;
                        if (cell >= 'a' && cell <= 'f') {
                            state |= (1 << (cell - 'a'));
                        }
                        if (dp[cur.state][cur.pos] + 1 < dp[state][neigh]) {
                            dp[state][neigh] = dp[cur.state][cur.pos] + 1;
                            queue.offer(new Pair(state, neigh));
                        }
                        if (state == (1 << keyCount) - 1) {
                            return dp[state][neigh];
                        }
                    }
                }
            }
        }
        return -1;
    }

    class Pair {
        int pos, state;
        Pair(int state, int pos) {
            this.state = state;
            this.pos = pos;
        }
    }
}