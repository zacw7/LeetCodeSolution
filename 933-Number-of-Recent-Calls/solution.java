class RecentCounter {
    private Queue<Integer> pingQ;

    public RecentCounter() {
        pingQ = new LinkedList();
    }

    public int ping(int t) {
        while (pingQ.peek() != null && t - pingQ.peek() > 3000) {
            pingQ.poll();
        }
        pingQ.add(t);
        return pingQ.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */