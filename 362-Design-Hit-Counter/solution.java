class HitCounter {

    private Deque<Integer> hitQueue;

    /** Initialize your data structure here. */
    public HitCounter() {
        this.hitQueue = new LinkedList();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hitQueue.offerLast(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!hitQueue.isEmpty() && timestamp - hitQueue.peekFirst() >= 300) {
            hitQueue.pollFirst();
        }
        return hitQueue.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */