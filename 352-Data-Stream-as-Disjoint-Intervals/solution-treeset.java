class SummaryRanges {

    TreeSet<Integer> treeSet;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        this.treeSet = new TreeSet();
    }

    public void addNum(int val) {
        treeSet.add(val);
    }

    public int[][] getIntervals() {
        List<int[]> res = new ArrayList();
        if (treeSet.isEmpty()) {
            return res.toArray(new int[res.size()][]);
        }
        int prev = -1;
        int[] interval = new int[2];
        for (int num : treeSet) {
            if (prev == -1) {
                interval[0] = interval[1] = num;
            } else if (prev + 1 == num) {
                interval[1] = num;
            } else if (prev + 1 < num) {
                res.add(interval);
                interval = new int[2];
                interval[0] = interval[1] = num;
            }
            prev = num;
        }
        res.add(interval);
        return res.toArray(new int[res.size()][]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */