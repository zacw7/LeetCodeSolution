class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjList = new List[n];
        for (int[] e : edges) {
            if (adjList[e[0]] == null) {
                adjList[e[0]] = new ArrayList();
            }
            adjList[e[0]].add(e[1]);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, adjList, visited, destination);
    }

    private Set<Integer> cache = new HashSet();
    private boolean dfs(int cur, List<Integer>[] adjList, boolean[] visited, int destination) {
        if (cache.contains(cur)) {
            return true;
        }
        if (cur == destination) {
            return adjList[cur] == null;
        }
        if (visited[cur] || adjList[cur] == null) {
            return false;
        }
        visited[cur] = true;
        for (int neigh : adjList[cur]) {
            if (dfs(neigh, adjList, visited, destination)) {
                continue;
            } else {
                return false;
            }
        }
        visited[cur] = false;
        cache.add(cur);
        return true;
    }
}