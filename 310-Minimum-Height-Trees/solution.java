class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> res = new HashSet();
        int[] degrees = new int[n];
        List<Integer>[] adjList = new List[n];
        for (int[] e : edges) {
            degrees[e[0]]++;
            degrees[e[1]]++;
            if (adjList[e[0]] == null) {
                adjList[e[0]] = new ArrayList();
            }
            if (adjList[e[1]] == null) {
                adjList[e[1]] = new ArrayList();
            }
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        for (int i = 0; i < n; i++) {
            res.add(i);
        }
        while (res.size() > 2) {
            List<Integer> tmp = new ArrayList();
            for (int i = 0; i < n; i++) {
                if (degrees[i] == 1) {
                    tmp.add(i);
                }
            }
            for (int node : tmp) {
                degrees[node]--;
                for (int neighbor : adjList[node]) {
                    degrees[neighbor]--;
                }
            }
            res.removeAll(tmp);
        }
        return new ArrayList(res);
    }
}