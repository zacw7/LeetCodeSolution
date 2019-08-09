class Solution {
    public boolean canCross(int[] stones) {
        int[] delta = new int[]{-1, 0, 1};
        Map<Integer, Integer> stoneToIndex = new HashMap();
        for (int i = 0; i < stones.length; i++) {
            stoneToIndex.put(stones[i], i);
        }
        Set<Integer>[] options = new Set[stones.length];
        for (int i = 0; i < options.length; i++) {
            options[i] = new HashSet();
        }
        options[0].add(1);
        for (int i = 0; i < stones.length - 1; i++) {
            if (options[i].isEmpty()) {
                continue;
            }
            for (int k : options[i]) {
                if (stoneToIndex.containsKey(stones[i] + k)) {
                    int j = stoneToIndex.get(stones[i] + k);
                    if (j == stones.length - 1) {
                        return true;
                    }
                    for (int d : delta) {
                        if (k + d > 0) {
                            options[j].add(k + d);
                        }
                    }
                }
            }
        }
        return false;
    }
}