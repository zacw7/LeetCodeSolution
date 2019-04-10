class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> queue
                = new PriorityQueue<int[]>((o1, o2) -> Math.abs(o1[0] * o1[0] + o1[1] * o1[1]) - Math.abs(o2[0] * o2[0] + o2[1] * o2[1]));
        for (int[] p : points) queue.add(p);
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) ans[i] = queue.poll();
        return ans;
    }
}