class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> intervals[a][1] - intervals[b][1]);
        Map<Integer, Integer> interCount = new HashMap();
        for (int i = 0; i < intervals.length; i++) {
            queue.offer(i);
            interCount.put(i, 0);
        }
        Set<Integer> set = new HashSet();
        List<Integer> toBeDelete = new ArrayList();
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int n = intervals[index][1];
            if (!set.contains(n)) {
                set.add(n);
                for (Map.Entry<Integer, Integer> entry : interCount.entrySet()) {
                    int i = entry.getKey();
                    if (n >= intervals[i][0] && n <= intervals[i][1]) {
                        entry.setValue(entry.getValue() + 1);
                    }
                    if (entry.getValue() == 2) {
                        toBeDelete.add(i);
                    }
                }
                for (int i : toBeDelete) {
                    queue.remove(i);
                    interCount.remove(i);
                }
                toBeDelete.clear();
            }
            if (interCount.containsKey(index)) {
                n--;
                set.add(n);
                for (Map.Entry<Integer, Integer> entry : interCount.entrySet()) {
                    int i = entry.getKey();
                    if (n >= intervals[i][0] && n <= intervals[i][1]) {
                        entry.setValue(entry.getValue() + 1);
                    }
                    if (entry.getValue() == 2) {
                        toBeDelete.add(i);
                    }
                }
                for (int i : toBeDelete) {
                    queue.remove(i);
                    interCount.remove(i);
                }
                toBeDelete.clear();
            }
        }
        return set.size();
    }
}