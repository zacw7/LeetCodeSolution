class Solution {
    // Heap
    // Time: O(nlogk)
    // Space: O(k)
    public int[][] kClosest(int[][] points, int K) {
        int[][] ans = new int[K][2];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        for (int i = 0; i < K; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}