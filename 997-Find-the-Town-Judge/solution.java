class Solution {
    public int findJudge(int N, int[][] trust) {
        Set<Integer> civilians = new HashSet();
        Map<Integer, Integer> trustMap = new HashMap();
        for (int[] t : trust) {
            civilians.add(t[0]);
            trustMap.put(t[1], trustMap.getOrDefault(t[1], 0) + 1);
        }
        for (int i = 1; i <= N; i++) {
            if (!civilians.contains(i) && trustMap.getOrDefault(i, 0) == N - 1) {
                return i;
            }
        }
        return -1;
    }
}