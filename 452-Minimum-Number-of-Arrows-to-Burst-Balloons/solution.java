class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        int minShots = 0;
        for (int[] p : points) {
            if (!pq.isEmpty() && pq.peek()[1] < p[0]) {
                pq.clear();
            }
            if (pq.isEmpty()) {
                minShots++;
            }
            pq.offer(p);
        }
        return minShots;
    }
}