class Solution {

    // SC: O(n)
    private Map<Integer, List<Integer>> idxMap;
    private Random rand;

    // TC: O(n)
    public Solution(int[] nums) {
        this.idxMap = new HashMap();
        this.rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = idxMap.getOrDefault(nums[i], new ArrayList());
            list.add(i);
            idxMap.put(nums[i], list);
        }
    }

    // TC: O(1)
    public int pick(int target) {
        List<Integer> list = idxMap.get(target);
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */