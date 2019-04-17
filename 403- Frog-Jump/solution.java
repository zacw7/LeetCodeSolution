class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length < 2 || stones[1] != 1) {
            return false;
        }

        if (stones.length == 2 && stones[1] == 1) {
            return true;
        }

        Map<Integer, Set<Integer>> jumpMap = new HashMap();
        Set<Integer> jumps = new HashSet();
        jumps.add(1);
        jumps.add(2);
        jumpMap.put(1, jumps);
        for (int i = 2; i < stones.length; i++) {
            jumpMap.put(stones[i], new HashSet());
        }

        int target = stones[stones.length - 1];
        for (int i = 1; i < stones.length; i++) {
            int curr = stones[i];
            Set<Integer> jumpOptions = jumpMap.get(curr);
            for (int option : jumpOptions) {
                if (curr + option == target) {
                    return true;
                }
                if (jumpMap.containsKey(curr + option)) {
                    Set<Integer> nextOptions = jumpMap.get(curr + option);
                    nextOptions.add(option + 1);
                    if (option > 0) nextOptions.add(option);
                    if (option - 1 > 0) nextOptions.add(option - 1);
                    jumpMap.put(curr + option, nextOptions);
                }
            }
        }

        return false;
    }

}