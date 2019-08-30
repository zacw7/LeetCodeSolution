class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int s : sticks) {
            pq.offer(s);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int s1 = pq.poll(), s2 = pq.poll();
            cost += s1 + s2;
            pq.offer(s1 + s2);
        }
        return cost;
    }
}