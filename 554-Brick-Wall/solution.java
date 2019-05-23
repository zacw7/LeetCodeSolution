class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> edgeCount = new HashMap();
        for (List<Integer> row : wall) {
            int cur = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                cur += row.get(i);
                edgeCount.put(cur, edgeCount.getOrDefault(cur, 0) + 1);
            }
        }
        int least = wall.size();
        for (int count : edgeCount.values()) {
            least = Math.min(least, wall.size() - count);
        }
        return least;
    }
}