class Solution {
    // dp + treemap
    // T: O(nlogn)
    // S: O(n)
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // dp[i][0]: whether i is a good index after an even jump
        // dp[i][1]: whether j is a good index after an odd jump
        boolean[][] dp = new boolean[A.length][2];
        dp[A.length - 1][0] = dp[A.length - 1][1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        treeMap.put(A[A.length - 1], A.length - 1);
        for (int i = A.length - 2; i >= 0; i--) {
            // for dp[i][0], the next jump is an odd jump.
            // if the next position(after an odd jump) is good, then i is good
            // the next position: the smallest value which is larger than or eaqul to A[i]
            if (treeMap.ceilingKey(A[i]) == null) {
                dp[i][0] = false;
            } else {
                int next = treeMap.ceilingEntry(A[i]).getValue();
                dp[i][0] = dp[next][1];
            }
            // for dp[i][1], the next jump is an even jump.
            // if the next position(after an even jump) is good, then i is good
            // the next position: the largest value which is smaller than or eaqul to A[i]
            // => a monotonous increasing stack can help
            if (treeMap.floorKey(A[i]) == null) {
                dp[i][1] = false;
            } else {
                int next = treeMap.floorEntry(A[i]).getValue();
                dp[i][1] = dp[next][0];
            }

            treeMap.put(A[i], i);
        }

        // count the good indexes
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (dp[i][0]) {
                count++;
            }
        }
        return count;
    }
}