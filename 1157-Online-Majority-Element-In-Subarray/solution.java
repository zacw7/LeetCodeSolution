class MajorityChecker {

    private Map<Integer, List<Integer>> map;

    public MajorityChecker(int[] arr) {
        this.map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList());
            list.add(i);
            map.put(arr[i], list);
        }
    }

    public int query(int left, int right, int threshold) {
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int l = 0, r = list.size() - 1;
            while ((r - l + 1) >= threshold && (list.get(l) < left || list.get(r) > right)) {
                if (list.get(l) < left) {
                    l++;
                }
                if (list.get(r) > right) {
                    r--;
                }
            }
            if (r - l + 1 >= threshold) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */