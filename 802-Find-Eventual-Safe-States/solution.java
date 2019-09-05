class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        List<Integer>[] adjList = new List[N];
        int[] degree = new int[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList();
        }
        for (int i = 0; i < N; i++) {
            for (int neigh : graph[i]) {
                adjList[neigh].add(i);
                degree[i]++;
            }
        }
        List<Integer> res = new ArrayList();
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < N; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
                res.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int neigh : adjList[cur]) {
                degree[neigh]--;
                if (degree[neigh] == 0) {
                    queue.offer(neigh);
                    res.add(neigh);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}