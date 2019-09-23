class Solution {
    public int smallestCommonElement(int[][] mat) {
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        for (int[] row : mat) {
            for (int c : row) {
                treeMap.put(c, treeMap.getOrDefault(c, 0) + 1);
            }
        }
        int R = mat.length;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            if (entry.getValue() == R) {
                return entry.getKey();
            }
        }
        return -1;
    }
}