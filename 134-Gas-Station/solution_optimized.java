class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int N = gas.length;
        int[] remains = new int[N];
        boolean skip = false;
        for (int start = 0; start < N; start++) {
            if (gas[start] < cost[start]) {
                skip = false;
                continue;
            }
            if (skip) continue;
            int tank = gas[start] - cost[start];
            int cur = start + 1;
            while (cur % N != start) {
                tank = tank + gas[cur % N] - cost[cur % N];
                if (tank < 0) break;
                cur++;
            }
            if (cur == start + N) return start;
            else skip = true;
        }
        return -1;
    }
}