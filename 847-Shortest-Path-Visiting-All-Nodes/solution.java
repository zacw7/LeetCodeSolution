class Solution {
    public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int[][] dp = new int[N][1 << N];
        Queue<Pair> queue = new LinkedList();
        for (int i = 0; i < N; i++) {
            int node = i, state = 1 << i;
            queue.offer(new Pair(node, state));
        }
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            for (int next : graph[cur.node]) {
                int state = (1 << next) | cur.state;
                if (state == (1 << N) - 1) {
                    return dp[cur.node][cur.state] + 1;
                }
                if (dp[next][state] == 0) {
                    dp[next][state] = dp[cur.node][cur.state] + 1;
                    queue.offer(new Pair(next, state));
                }
            }
        }
        return 0;
    }

    class Pair {
        int node, state;
        Pair(int node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}