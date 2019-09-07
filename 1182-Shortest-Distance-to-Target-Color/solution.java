class Solution {
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        List<Integer>[] colorPos = new List[4];
        for (int c = 1; c <= 3; c++) {
            colorPos[c] = new ArrayList();
        }
        for (int i = 0; i < colors.length; i++) {
            colorPos[colors[i]].add(i);
        }
        List<Integer> res = new ArrayList();
        for (int[] q : queries) {
            int index = q[0], color = q[1];
            res.add(minDist(colorPos[color], index));
        }
        return res;
    }

    private int minDist(List<Integer> pos, int index) {
        if (pos.isEmpty()) {
            return -1;
        }
        int lo = 0, hi = pos.size() - 1;
        if (pos.get(lo) >= index) {
            return pos.get(lo) - index;
        }
        if (pos.get(hi) <= index) {
            return index - pos.get(hi);
        }
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (pos.get(mid) < index) {
                lo = mid;
            } else if (pos.get(mid) > index) {
                hi = mid;
            } else {
                return 0;
            }
        }
        if (index - pos.get(lo) <= pos.get(hi) - index) {
            return index - pos.get(lo);
        } else {
            return pos.get(hi) - index;
        }
    }
}