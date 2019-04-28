class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        dfs(nums, 0, new ArrayList(), ans);
        return ans;
    }

    private void dfs(int[] nums, int index, List<Integer> cur, List<List<Integer>> ans) {
        if (index == nums.length) {
            if (cur.size() > 1) {
                ans.add(new ArrayList(cur));
            }
            return;
        }

        if (cur.isEmpty() || nums[index] > cur.get(cur.size() - 1)) {
            dfs(nums, index + 1, cur, ans);
        }
        if (cur.isEmpty() || nums[index] >= cur.get(cur.size() - 1)) {
            cur.add(nums[index]);
            dfs(nums, index + 1, cur, ans);
            cur.remove(cur.size() - 1);
        } else {
            dfs(nums, index + 1, cur, ans);
        }
    }
}