class Solution {
    public int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap();
        int maxLen = 0;
        int tr = 0, n_tr = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                tr++;
                maxLen = Math.max(maxLen, i - map.getOrDefault(n_tr - tr + 1, i));
            } else {
                n_tr++;
            }
            if (tr > n_tr) {
                maxLen = i + 1;
            } else if (n_tr > tr && !map.containsKey(n_tr - tr)) {
                map.put(n_tr - tr, i);
            }
        }
        return maxLen;
    }
}