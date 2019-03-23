class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        int subsetCount = 1;
        for (int i = 0; i < nums.length; i++) subsetCount *= 2;
        subsetCount -= 1;
        while (subsetCount >= 0) {
            List<Integer> subset = new ArrayList();
            for (int comb = subsetCount, i = 0; comb > 0 && i < nums.length; i++, comb >>= 1) {
                if ((comb & 1) > 0) subset.add(nums[i]);
            }
            res.add(subset);
            subsetCount--;
        }
        return res;
    }
}