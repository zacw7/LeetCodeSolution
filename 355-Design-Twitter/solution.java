class Twitter {
    //1. postTweet - O(1)
    //2. getNewsFeed - O(nlogn)
    //3. follow - O(1)
    //4. unfollow - O(1)
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<Tweet>> tweetMap;
    private int SEQ;

    class Tweet implements Comparable<Tweet> {
        int tweetId, seq;
        Tweet(int tweetId, int seq) {
            this.tweetId = tweetId;
            this.seq = seq;
        }

        @Override
        public int compareTo(Tweet t) {
            return t.seq - this.seq;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        this.SEQ = 1;
        this.followMap = new HashMap();
        this.tweetMap = new HashMap();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet());
        followees.add(userId);
        followMap.put(userId, followees);
        List<Tweet> list = tweetMap.getOrDefault(userId, new ArrayList());
        list.add(new Tweet(tweetId, SEQ++));
        tweetMap.put(userId, list);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList();
        if (followMap.containsKey(userId)) {
            Queue<Tweet> queue = new PriorityQueue();
            Set<Integer> followees = followMap.get(userId);
            for (Integer followeeId : followees) {
                if (tweetMap.containsKey(followeeId)) queue.addAll(tweetMap.get(followeeId));
            }
            while (!queue.isEmpty() && feed.size() < 10) {
                feed.add(queue.poll().tweetId);
            }
        }
        return feed;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = followMap.getOrDefault(followerId, new HashSet());
        followees.add(followeeId);
        followMap.put(followerId, followees);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId != followeeId && followMap.containsKey(followerId)) {
            Set<Integer> followees = followMap.get(followerId);
            if (followees.contains(followeeId)) followees.remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */