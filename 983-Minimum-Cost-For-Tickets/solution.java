class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] memo = new int[days[days.length - 1] + 1];
        memo[days[0]] = Math.min(Math.min(costs[0], costs[1]), costs[2]);
        for (int i = 1; i < days.length; i++) {
            int day = days[i];
            for (int j = days[i - 1] + 1; j < day; j++) {
                memo[j] = memo[j - 1];
            }
            int cur = memo[day - 1] + costs[0];
            if (day >= 7) cur = Math.min(memo[day - 7] + costs[1], cur);
            else cur = Math.min(costs[1], cur);
            if (day >= 30) cur = Math.min(memo[day - 30] + costs[2], cur);
            else cur = Math.min(costs[2], cur);
            memo[day] = cur;
        }
        return memo[memo.length - 1];
    }
}