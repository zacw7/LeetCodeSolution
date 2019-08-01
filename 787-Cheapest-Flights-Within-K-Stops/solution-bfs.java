class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList();
        }
        for (int[] f : flights) {
            adjList[f[0]].add(new int[]{f[1], f[2]});
        }
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{src, 0});
        while (!queue.isEmpty() && K-- >= 0) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                for (int[] next : adjList[cur[0]]) {
                    int stop = next[0], cost = cur[1] + next[1];
                    if (cost < minCost[stop]) {
                        minCost[stop] = cost;
                        queue.offer(new int[]{stop, cost});
                    }
                }
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}