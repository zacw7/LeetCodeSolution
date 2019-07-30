class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }
        PriorityQueue<int[]> maxQueue = new PriorityQueue<int[]>((a, b) -> (b[1] - a[1]));
        int i = 0, count = 0, fuel = startFuel;
        while (i < stations.length && stations[i][0] <= fuel) {
            maxQueue.offer(stations[i++]);
        }
        while (!maxQueue.isEmpty() && fuel < target) {
            int[] s = maxQueue.poll();
            fuel += s[1];
            while (i < stations.length && stations[i][0] <= fuel) {
                maxQueue.offer(stations[i++]);
            }
            count++;
        }
        return (fuel < target) ? -1 : count;
    }
}