class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length == 0) {
            return ans;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        permuteHelper(nums, new ArrayList(), used, ans);

        return ans;
    }

    private void permuteHelper(int[] nums, List<Integer> list, boolean[] used, List<List<Integer>> ans) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            permuteHelper(nums, list, used, ans);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}