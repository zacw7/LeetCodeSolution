class Solution {
    public int reachableNodes(int[][] edges, int M, int N) {
        Map<Integer, Integer>[] adjMap = new Map[N];
        for (int i = 0; i < N; i++) {
            adjMap[i] = new HashMap();
        }
        for (int[] e : edges) {
            adjMap[e[0]].putIfAbsent(e[1], e[2]);
            adjMap[e[1]].putIfAbsent(e[0], e[2]);
        }
        int[][] reach = new int[N][N];
        int[] moveLeft = new int[N];
        Arrays.fill(moveLeft, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, M});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], move = cur[1];
            if (moveLeft[node] >= move) {
                continue;
            }
            moveLeft[node] = move;
            for (Map.Entry<Integer, Integer> entry : adjMap[node].entrySet()) {
                int next = entry.getKey(), cost = entry.getValue();
                if (move > cost) {
                    reach[node][next] = cost;
                    pq.offer(new int[]{next, move - cost - 1});
                } else {
                    reach[node][next] = move;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (moveLeft[i] >= 0) {
                res++;
            }
            for (int j = i + 1; j < N; j++) {
                res += Math.min(adjMap[i].getOrDefault(j, 0), reach[i][j] + reach[j][i]);
            }
        }
        return res;
    }
}