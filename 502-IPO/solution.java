class Solution {
    // TreeMap + PriorityQueue
    // TC: O((N+K)logN)
    // SC: O(N)
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        TreeMap<Integer, List<Integer>> projectMap = new TreeMap();
        for (int i = 0; i < Profits.length; i++) {
            List<Integer> projects = projectMap.getOrDefault(Capital[i], new ArrayList());
            projects.add(Profits[i]);
            projectMap.put(Capital[i], projects);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        while (k-- > 0) {
            int cur = 0;
            Map<Integer, List<Integer>> headMap = projectMap.headMap(W, true);
            for (List<Integer> projects : headMap.values()) {
                maxHeap.addAll(projects);
            }
            List<Integer> keysToRemoved = new ArrayList(headMap.keySet());
            for (int key : keysToRemoved) {
                projectMap.remove(key);
            }
            if (maxHeap.isEmpty()) {
                break;
            } else {
                W += maxHeap.poll();
            }
        }
        return W;
    }
}