class Solution {
    // bfs
    public int reachableNodes(int[][] edges, int M, int N) {
        if (M == 0 || N == 0) {
            return 0;
        }
        List<int[]>[] adjList = new List[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            adjList[e[0]].add(new int[]{e[1], e[2], i});
            adjList[e[1]].add(new int[]{e[0], e[2], i});
        }
        int[] movesLeft = new int[N];
        Arrays.fill(movesLeft, -1);
        movesLeft[0] = M;
        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, M});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0], m = cur[1];
            for (int[] next : adjList[node]) {
                if (m - next[1] - 1 > movesLeft[next[0]]) {
                    movesLeft[next[0]] = m - next[1] - 1;
                    queue.offer(new int[]{next[0], movesLeft[next[0]]});
                }
            }
        }
        int nodes = 0;
        int[] edgeNodes = new int[edges.length];
        for (int i = 0; i < N; i++) {
            if (movesLeft[i] == -1) {
                continue;
            }
            nodes++;
            if (movesLeft[i] > 0) {
                for (int[] next : adjList[i]) {
                    int id = next[2];
                    edgeNodes[id] = Math.min(edges[id][2], edgeNodes[id] + movesLeft[i]);
                }
            }
        }
        for (int en : edgeNodes) {
            nodes += en;
        }
        return nodes;
    }
}