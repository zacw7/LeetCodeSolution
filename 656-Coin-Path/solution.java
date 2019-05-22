class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] dp = new int[A.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Map<Integer, List<Integer>> pathMap = new HashMap();
        dp[0] = A[0];
        List<Integer> path0 = new ArrayList();
        path0.add(1);
        pathMap.put(0, path0);
        for (int i = 1; i < A.length; i++) {
            if (A[i] == -1) {
                continue;
            }
            List<Integer> path = new ArrayList();
            for (int j = i - B; j < i; j++) {
                if (j < 0 || A[j] == -1) {
                    continue;
                }
                List<Integer> cur = new ArrayList(pathMap.get(j));
                cur.add(i + 1);
                if (A[i] + dp[j] < dp[i] || path.isEmpty()
                        || (A[i] + dp[j] == dp[i] && compare(cur, path) < 0)) {
                    dp[i] = A[i] + dp[j];
                    path = cur;
                }
            }
            if (path.isEmpty()) {
                return path;
            }
            pathMap.put(i, path);
        }
        return pathMap.getOrDefault(A.length - 1, new ArrayList());
    }

    private int compare(List<Integer> l1, List<Integer> l2) {
        int i = 0;
        while (i < l1.size() && i < l2.size()) {
            if (l1.get(i) != l2.get(i)) {
                return l1.get(i) - l2.get(i);
            } else {
                i++;
            }
        }
        if (i < l1.size()) {
            return 1;
        } else if (i < l2.size()) {
            return -1;
        } else {
            return 0;
        }
    }
}