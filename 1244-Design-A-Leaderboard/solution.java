class Leaderboard {

    private Map<Integer, Integer> scoreMap;

    public Leaderboard() {
        this.scoreMap = new HashMap();
    }

    public void addScore(int playerId, int score) {
        scoreMap.put(playerId, scoreMap.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int s : scoreMap.values()) {
            if (pq.size() < K) {
                pq.offer(s);
            } else if (pq.peek() < s) {
                pq.poll();
                pq.offer(s);
            }
        }
        int res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        return res;
    }

    public void reset(int playerId) {
        scoreMap.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */