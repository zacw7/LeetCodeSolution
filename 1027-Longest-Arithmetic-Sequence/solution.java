class Solution {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap();
        int maxLen = 1;
        for (int i = 0; i < A.length; i++) {
            Map<Integer, Integer> cur = map.getOrDefault(A[i], new HashMap());
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                if (diff == 0) {
                    continue;
                }
                Map<Integer, Integer> prev = map.get(A[j]);
                int len = prev.getOrDefault(diff, 1) + 1;
                cur.put(diff, len);
                maxLen = Math.max(maxLen, len);
            }
            map.put(A[i], cur);
        }
        return maxLen;
    }
}