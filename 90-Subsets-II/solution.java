class Solution {
    // T: (2^n)
    // O: (n!)
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null) {
            return ans;
        }
        Arrays.sort(nums);
        subsetHelper(nums, 0, new ArrayList(), ans);
        return ans;
    }

    private void subsetHelper(int[] nums, int index, List<Integer> list, List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(list);
            return;
        }

        if (list.size() == 0 || nums[index] != list.get(list.size() - 1)) {
            subsetHelper(nums, index + 1, new ArrayList(list), ans);
        }

        list.add(nums[index]);
        subsetHelper(nums, index + 1, list, ans);
    }
}