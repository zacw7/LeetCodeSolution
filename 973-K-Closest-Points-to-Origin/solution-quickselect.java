class Solution {
    // quick select
    // Time: O(n)
    // Space: O(1)
    public int[][] kClosest(int[][] points, int K) {
        if (K <= 0) {
            return new int[0][2];
        }
        if (K >= points.length) {
            return points;
        }
        partition(points, 0, points.length - 1, K);
        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = points[i];
        }
        return ans;
    }

    private void partition(int[][] points, int start, int end, int K) {
        if (start >= end) {
            return;
        }
        int pivot = end;
        int pivotDist = dist(points[pivot]);
        int i = start, j = start;
        while (j < pivot) {
            int curDist = dist(points[j]);
            if (curDist < pivotDist) {
                swap(points, i, j);
                i++;
            }
            j++;
        }
        swap(points, i, pivot);
        if (i - start + 1 > K) {
            partition(points, start, i - 1, K);
        } else if (i - start + 1 < K) {
            partition(points, i + 1, end, K - (i - start + 1));
        } else {
            return;
        }
    }

    private int dist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}