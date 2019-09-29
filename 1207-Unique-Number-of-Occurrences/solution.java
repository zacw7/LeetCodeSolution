class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occ = new HashMap();
        for (int n : arr) {
            occ.put(n, occ.getOrDefault(n, 0) + 1);
        }
        Set<Integer> set = new HashSet();
        for (int o : occ.values()) {
            if (set.contains(o)) {
                return false;
            } else {
                set.add(o);
            }
        }
        return true;
    }
}