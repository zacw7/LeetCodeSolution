class Solution {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);
        for (int i = 1; i < A.length; i++) {
            pq.offer(new int[]{0, i});
        }
        while (--K > 0) {
            int[] pair = pq.poll();
            pair[0]++;
            if (pair[0] < pair[1]) {
                pq.offer(pair);
            }
        }
        int[] pair = pq.peek();
        return new int[]{A[pair[0]], A[pair[1]]};
    }
}