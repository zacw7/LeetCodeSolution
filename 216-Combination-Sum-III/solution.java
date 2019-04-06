class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        int[] nums = new int[9];
        for (int i = 1; i <= 9; i++) nums[i - 1] = i;
        backtrack(new ArrayList(), nums, 0, k, n, ans);
        return ans;
    }

    private void backtrack(List<Integer> list, int[] nums, int i, int k, int n, List<List<Integer>> ans) {
        if (k == 0 && n == 0) ans.add(new ArrayList(list));
        if (k == 0 || n <= 0 || i == nums.length) return;
        list.add(nums[i]);
        backtrack(list, nums, i + 1, k - 1, n - nums[i], ans);
        list.remove(list.size() - 1);
        backtrack(list, nums, i + 1, k, n, ans);
    }
}