class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList();
        subsetHelper(nums, new ArrayList(), 0, subsets);
        return subsets;
    }

    private void subsetHelper(int[] nums, List<Integer> curr, int index, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(curr);
            return;
        }
        subsetHelper(nums, new ArrayList(curr), index + 1, subsets);
        curr.add(nums[index]);
        subsetHelper(nums, curr, index + 1, subsets);
    }
}