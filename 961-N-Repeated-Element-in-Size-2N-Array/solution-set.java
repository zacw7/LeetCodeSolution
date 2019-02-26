class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> seen = new HashSet();
        for (int n : A) {
            if (seen.contains(n)) return n;
            else seen.add(n);
        }
        return 0;
    }
}