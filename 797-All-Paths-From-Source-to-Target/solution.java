class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList();
        searchPath(graph, new boolean[graph.length], 0, new ArrayList(), paths);
        return paths;
    }

    private void searchPath(int[][]graph, boolean[] visited, int node, List<Integer> cur, List<List<Integer>> paths) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        cur.add(node);
        if (node == graph.length - 1) {
            paths.add(new ArrayList(cur));
        } else {
            for (int next : graph[node]) {
                searchPath(graph, visited, next, cur, paths);
            }
        }
        visited[node] = false;
        cur.remove(cur.size() - 1);
    }
}