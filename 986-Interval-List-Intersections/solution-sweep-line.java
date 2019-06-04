class Solution {
    // Sweep Line
    // TC: O(NlogN)
    // SC: O(N)
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        Integer[] points = new Integer[A.length * 2 + B.length * 2];
        int i = 0;
        for (int[] a : A) {
            points[i++] = a[0];
            points[i++] = -a[1];
        }
        for (int[] b : B) {
            points[i++] = b[0];
            points[i++] = -b[1];
        }
        Arrays.sort(points, (o1, o2) -> (Math.abs(o1) == Math.abs(o2)) ? o2 - o1 : Math.abs(o1) - Math.abs(o2));
        List<int[]> intervals = new ArrayList();
        int[] interval = new int[2];
        int left = 0;
        for (int p : points) {
            if (p >= 0) {
                left++;
                if (left == 2) {
                    interval = new int[2];
                    interval[0] = p;
                }
            } else {
                left--;
                if (left == 1) {
                    interval[1] = -p;
                    intervals.add(interval);
                }
            }
        }
        return intervals.toArray(new int[intervals.size()][]);
    }
}