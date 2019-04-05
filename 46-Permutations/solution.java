class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        dfs(nums, 0, ans);
        return ans;
    }

    private void dfs(int[] nums, int cur, List<List<Integer>> ans) {
        if (cur >= nums.length) return;
        List<Integer> list = new ArrayList(nums.length);
        for (int n : nums) list.add(n);
        ans.add(list);
        for (int i = cur; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                dfs(nums, i + 1, ans);
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
    }
}