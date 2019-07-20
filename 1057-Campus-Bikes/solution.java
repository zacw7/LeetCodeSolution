class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int N = workers.length, M = bikes.length;
        List<Pair> pairs = new ArrayList();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                pairs.add(new Pair(i, j, Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1])));
            }
        }
        pairs.sort((a, b) -> {
            if (a.dist == b.dist) {
                if (a.worker == b.worker) {
                    return a.bike - b.bike;
                } else {
                    return a.worker - b.worker;
                }
            } else {
                return a.dist - b.dist;
            }
        });
        boolean[] assignedBike = new boolean[M];
        int[] assign = new int[N];
        Arrays.fill(assign, -1);
        for (Pair p : pairs) {
            if (assign[p.worker] == -1 && !assignedBike[p.bike]) {
                assign[p.worker] = p.bike;
                assignedBike[p.bike] = true;
            }
        }
        return assign;
    }

    class Pair {
        int worker, bike, dist;
        Pair(int worker, int bike, int dist) {
            this.worker = worker;
            this.bike = bike;
            this.dist = dist;
        }
    }
}