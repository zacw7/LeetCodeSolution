class Solution {
    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0];
        }
        int N = intervals.length;
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < N; i++) {
            map.putIfAbsent(intervals[i][0], i);
        }
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            Integer right = map.ceilingKey(intervals[i][1]);
            if (right == null) {
                ans[i] = -1;
            } else {
                ans[i] = map.get(right);
            }
        }
        return ans;
    }
}