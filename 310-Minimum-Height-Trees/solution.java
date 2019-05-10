class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList();
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add(0);
            return res;
        }
        int[] degrees = new int[n];
        Map<Integer, Set<Integer>> adjNodes = new HashMap();
        for (int[] e : edges) {
            degrees[e[0]]++;
            degrees[e[1]]++;
            Set<Integer> s1 = adjNodes.getOrDefault(e[0], new HashSet());
            Set<Integer> s2 = adjNodes.getOrDefault(e[1], new HashSet());
            s1.add(e[1]);
            s2.add(e[0]);
            adjNodes.put(e[0], s1);
            adjNodes.put(e[1], s2);
        }
        Queue<Integer> leaves = new LinkedList();
        while (adjNodes.size() > 2) {
            for (int i = 0; i < n; i++) {
                if (degrees[i] == 1) {
                    leaves.offer(i);
                }
            }
            while (!leaves.isEmpty()) {
                int node = leaves.poll();
                degrees[node]--;
                for (int neighbor : adjNodes.get(node)) {
                    degrees[neighbor]--;
                    Set<Integer> set = adjNodes.get(neighbor);
                    set.remove(node);
                    adjNodes.put(neighbor, set);
                }
                adjNodes.remove(node);
            }
        }
        return new ArrayList(adjNodes.keySet());
    }
}