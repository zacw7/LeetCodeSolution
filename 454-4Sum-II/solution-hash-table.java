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
                int sum = a + b;
                targetMap.put(-sum, targetMap.getOrDefault(-sum, 0) + 1);
            }
        }
        int count = 0;
        for (int c = 0; c < C.length; c++) {
            for (int d = 0; d < D.length; d++) {
                int sum = C[c] + D[d];
                if (targetMap.containsKey(sum)) {
                    count += targetMap.get(sum);
                }
            }
        }
        return count;
    }
}