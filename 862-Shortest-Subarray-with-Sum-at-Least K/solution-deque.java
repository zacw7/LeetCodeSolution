class Solution {
    // Deque
    // TC: O(N)
    // SC: O(N)
    public int shortestSubarray(int[] A, int K) {
        if (A[0] >= K) {
            return 1;
        }
        int[] prefixSum = new int[A.length + 1];
        Deque<Integer> deque = new LinkedList();
        deque.offerLast(0);
        int len = A.length + 1;
        for (int i = 1; i <= A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i - 1];
            while (!deque.isEmpty() && i - deque.peekFirst() >= len) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= K) {
                len = i - deque.pollFirst();
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return (len == A.length + 1) ? -1 : len;
    }
}