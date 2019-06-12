class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> invalid = new HashSet();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                invalid.add(fronts[i]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!invalid.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
            if (!invalid.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }
}