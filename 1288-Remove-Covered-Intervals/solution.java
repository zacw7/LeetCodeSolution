class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int N = intervals.length;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0]) ? b[1] - a[1] : a[0] - b[0]);
        int count = 0, right = intervals[0][1];
        for (int i = 1; i < N; i++) {
            if (right >= intervals[i][1]) {
                count++;
            } else {
                right = intervals[i][1];
            }
        }
        return N - count;
    }
}