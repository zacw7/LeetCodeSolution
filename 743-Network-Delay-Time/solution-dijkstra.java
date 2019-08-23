class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        List<int[]>[] adjList = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList();
        }
        for (int[] t : times) {
            adjList[t[0]].add(new int[]{t[1], t[2]});
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{K, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];
            if (dist[node] <= cost) {
                continue;
            }
            dist[node] = cost;
            for (int[] next : adjList[cur[0]]) {
                pq.offer(new int[]{next[0], cost + next[1]});
            }
        }
        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist == Integer.MAX_VALUE ? -1 : maxDist;
    }
}