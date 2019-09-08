class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start == destination) return 0;
        int N = distance.length;
        int dist = 0, i = start;
        while (i % N != destination) {
            dist += distance[i % N];
            i++;
        }
        int total = 0;
        for (int d : distance) {
            total += d;
        }
        return Math.min(dist, total - dist);
    }
}