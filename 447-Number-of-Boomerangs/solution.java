class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        Map<Integer, Integer> distMap = new HashMap();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                int distance = x * x + y * y;
                distMap.put(distance, distMap.getOrDefault(distance, 0) + 1);
            }
            for (int v : distMap.values()) {
                count += v * (v - 1);
            }
            distMap.clear();
        }
        return count;
    }
}