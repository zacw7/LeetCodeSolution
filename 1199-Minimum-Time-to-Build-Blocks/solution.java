class Solution {
    public int minBuildTime(int[] blocks, int split) {
        if (blocks == null || blocks.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int b : blocks) {
            pq.offer(b);
        }
        while (pq.size() > 1) {
            pq.offer(Math.max(pq.poll(), pq.poll()) + split);
        }
        return pq.peek();
    }
}