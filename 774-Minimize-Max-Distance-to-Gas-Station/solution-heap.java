class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        PriorityQueue<int[]> distHeap = new PriorityQueue<int[]>((a, b) -> {
            double avgA = 1.0 * a[0] / a[1];
            double avgB = 1.0 * b[0] / b[1];
            if (avgA < avgB) {
                return 1;
            } else if (avgA > avgB) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int i = 1; i < stations.length; i++) {
            distHeap.offer(new int[]{stations[i] - stations[i - 1], 1});
        }
        while (K-- > 0) {
            int[] cur = distHeap.poll();
            cur[1]++;
            distHeap.offer(cur);
        }
        int[] max = distHeap.peek();
        return 1.0 * max[0] / max[1];
    }
}