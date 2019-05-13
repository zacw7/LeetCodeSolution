class SummaryRanges {

    TreeMap<Integer, int[]> intervalMap;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.intervalMap = new TreeMap();
    }

    public void addNum(int val) {
        if (intervalMap.containsKey(val)) {
            return;
        }
        Integer lo = intervalMap.lowerKey(val);
        Integer hi = intervalMap.higherKey(val);
        if (lo != null && hi != null
                && intervalMap.get(lo)[1] + 1 == val
                && intervalMap.get(hi)[0] - 1 == val) {
            intervalMap.put(lo, new int[]{lo, intervalMap.get(hi)[1]});
            intervalMap.remove(hi);
        } else if ((lo != null && intervalMap.get(lo)[1] >= val)
                || (hi != null && intervalMap.get(hi)[0] <= val)) {
            return;
        } else if (lo != null && intervalMap.get(lo)[1] + 1 == val) {
            intervalMap.put(lo, new int[]{lo, val});
        } else if (hi != null && intervalMap.get(hi)[0] - 1 == val) {
            intervalMap.put(val, new int[]{val, intervalMap.get(hi)[1]});
            intervalMap.remove(hi);
        } else {
            intervalMap.put(val, new int[]{val, val});
        }
    }

    public int[][] getIntervals() {
        return intervalMap.values().toArray(new int[intervalMap.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */