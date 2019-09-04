class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList();
        }
        for (int[] e : edges){
            degree[e[0]]++;
            degree[e[1]]++;
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        List<Integer> res = new ArrayList();
        int left = n;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                degree[i]--;
                queue.offer(i);
            }
        }
        if (queue.isEmpty()) {
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
        }
        while (left > 2 && !queue.isEmpty()) {
            int s = queue.size();
            while (s-- > 0) {
                int cur = queue.poll();
                for (int neigh : adjList[cur]) {
                    degree[neigh]--;
                    if (degree[neigh] == 1) {
                        queue.offer(neigh);
                    }
                }
                left--;
            }
        }
        while (!queue.isEmpty()) {
            res.add(queue.poll());
        }
        return res;
    }
}