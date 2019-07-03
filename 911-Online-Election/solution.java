class TopVotedCandidate {

    private int[] leads, times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leads = new int[persons.length];
        int[] count = new int[persons.length];
        int maxVote = 0;
        for (int i = 0; i < leads.length; i++) {
            int p = persons[i];
            count[p]++;
            if (count[p] >= maxVote) {
                leads[i] = p;
                maxVote = count[p];
            } else {
                leads[i] = leads[i - 1];
            }
        }
    }

    public int q(int t) {
        int lo = 0, hi = times.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (times[mid] < t) {
                lo = mid;
            } else if (times[mid] > t) {
                hi = mid - 1;
            } else {
                lo = mid;
                break;
            }
        }
        if (times[hi] <= t) {
            return leads[hi];
        } else {
            return leads[lo];
        }
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */