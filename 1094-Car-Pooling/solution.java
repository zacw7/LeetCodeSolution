class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Set<Integer> positions = new TreeSet();
        Map<Integer, Integer> startMap = new HashMap();
        Map<Integer, Integer> endMap = new HashMap();
        for (int[] t : trips) {
            int start = t[1], end = t[2];
            positions.add(start);
            positions.add(end);
            startMap.put(start, startMap.getOrDefault(start, 0) + t[0]);
            endMap.put(end, endMap.getOrDefault(end, 0) + t[0]);
        }
        int cur = 0;
        for (int p : positions) {
            cur -= endMap.getOrDefault(p, 0);
            cur += startMap.getOrDefault(p, 0);
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }
}