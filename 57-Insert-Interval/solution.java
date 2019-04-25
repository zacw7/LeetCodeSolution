class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        int idx = 0;
        while (idx < intervals.length) {
            int[] cur = intervals[idx];
            if (cur[1] < newInterval[0]) {
                list.add(cur);
            } else if (cur[0] > newInterval[1]) {
                break;
            } else {
                // merge
                newInterval[0] = Math.min(cur[0], newInterval[0]);
                newInterval[1] = Math.max(cur[1], newInterval[1]);
            }
            idx++;
        }
        list.add(newInterval);
        while (idx < intervals.length) {
            list.add(intervals[idx++]);
        }
        int[][] ans = new int[list.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}