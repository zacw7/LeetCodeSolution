class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Queue<Integer> onesQueue = new LinkedList();
        int count = 0, prev = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                onesQueue.offer(i);
            }
            if (onesQueue.size() > S) {
                prev = onesQueue.poll();
            }
            if (onesQueue.size() == S) {
                int cur = onesQueue.isEmpty() ? i : onesQueue.peek();
                count += cur - prev ;
            }
        }
        return count;
    }
}