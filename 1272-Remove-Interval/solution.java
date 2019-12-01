class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList();
        for (int[] itv : intervals) {
            if (itv[0] < toBeRemoved[0] && itv[1] > toBeRemoved[1]) {
                List<Integer> cur1 = new ArrayList();
                cur1.add(itv[0]);
                cur1.add(toBeRemoved[0]);
                res.add(cur1);
                List<Integer> cur2 = new ArrayList();
                cur2.add(toBeRemoved[1]);
                cur2.add(itv[1]);
                res.add(cur2);
                continue;
            } else if (itv[0] >= toBeRemoved[0] && itv[1] <= toBeRemoved[1]) {
                continue;
            } else if (itv[0] < toBeRemoved[0] && itv[1] > toBeRemoved[0]) {
                itv[1] = toBeRemoved[0];
            } else if (itv[1] > toBeRemoved[1] && itv[0] < toBeRemoved[1]) {
                itv[0] = toBeRemoved[1];
            }
            List<Integer> cur = new ArrayList();
            cur.add(itv[0]);
            cur.add(itv[1]);
            res.add(cur);
        }
        return res;
    }
}