class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int N = difficulty.length;
        Integer[] jobs = new Integer[N];
        for (int i = 0; i < N; i++) {
            jobs[i] = i;
        }
        Arrays.sort(jobs, (a, b) -> difficulty[a] - difficulty[b]);
        Arrays.sort(worker);
        int total = 0, i = 0, best = 0;
        for (int w : worker) {
            while (i < N && w >= difficulty[jobs[i]]) {
                best = Math.max(best, profit[jobs[i++]]);
            }
            total += best;
        }
        return total;
    }
}