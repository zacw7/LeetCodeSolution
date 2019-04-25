class Solution {
    // hashtable
    // T: O(n^2)
    // S: O(n)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || B == null || C == null || D == null) {
            return 0;
        }
        Map<Integer, Integer> targetMap = new HashMap();
        for (int a : A) {
            for (int b : B) {
                targetMap.put(a + b, targetMap.getOrDefault(a + b, 0) + 1);
            }
        }
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                count += targetMap.getOrDefault(- c - d, 0);
            }
        }
        return count;
    }
}