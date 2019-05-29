class Solution {
    // Hash Table
    // TC: O(N ^ 2) - Each point need to be paired with N - 1 other points
    // SC: T(N ^ 2) - C(N, 2) lines will be generated at most
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Map<String, Integer> pointCount = new HashMap();
        List<int[]> distinctPoints = new ArrayList();
        for (int[] p : points) {
            String key = Arrays.toString(p);
            if (pointCount.containsKey(key)) {
                pointCount.put(key, pointCount.get(key) + 1);
            } else {
                pointCount.put(key, 1);
                distinctPoints.add(p);
            }
        }
        if (distinctPoints.size() == 1) {
            return points.length;
        }
        Map<String, Integer> lineMap = new HashMap();
        for (int i = 0; i < distinctPoints.size(); i++) {
            for (int j = i + 1; j < distinctPoints.size(); j++) {
                int[] p1 = distinctPoints.get(i), p2 = distinctPoints.get(j);
                String k1 = Arrays.toString(p1), k2 = Arrays.toString(p2);
                String line = lineGenerator(p1, p2);
                lineMap.put(line, lineMap.getOrDefault(line, pointCount.get(k1)) + pointCount.get(k2));
            }
        }
        int max = 0;
        for (int v : lineMap.values()) {
            max = Math.max(max, v);
        }
        return max;
    }

    private String lineGenerator(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) {
            return Arrays.toString(p1) + "/" + "X";
        } else if (p1[1] == p2[1]) {
            return Arrays.toString(p1) + "/" + "0";
        } else {
            return Arrays.toString(p1) + "/" + 1.0 * (p1[0] - p2[0]) / (p1[1] - p2[1]);
        }
    }
}