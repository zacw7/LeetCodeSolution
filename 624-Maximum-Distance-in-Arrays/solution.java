class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        if (arrays == null || arrays.size() <= 1) {
            return 0;
        }

        int min = arrays.get(0).get(0), max = arrays.get(0).get(arrays.get(0).size() - 1);
        int dist = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> cur = arrays.get(i);
            dist = Math.max(dist, Math.abs(max - cur.get(0)));
            dist = Math.max(dist, Math.abs(min - cur.get(cur.size() - 1)));
            min = Math.min(min, cur.get(0));
            max = Math.max(max, cur.get(cur.size() - 1));
        }
        return dist;
    }
}