class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList();
        }
        for (int[] t : times) {
            adjList[t[0]].add(new int[]{t[1], t[2]});
        }
        int[] memo = new int[N + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[K] = 0;
        Queue<Integer> queue = new LinkedList();
        queue.offer(K);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] next : adjList[cur]) {
                int node = next[0], cost = memo[cur] + next[1];
                if (cost < memo[node]) {
                    memo[node] = cost;
                    queue.offer(node);
                }
            }
        }
        int time = 0;
        for (int i = 1; i <= N; i++) {
            if (memo[i] == Integer.MAX_VALUE) {
                return -1;
            } else {
                time = Math.max(time, memo[i]);
            }
        }
        return time;
    }
}