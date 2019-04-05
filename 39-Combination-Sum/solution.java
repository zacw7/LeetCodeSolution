class Solution {

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList();
        dfs(candidates, 0, target, new ArrayList());
        return ans;
    }

    private void dfs(int[] candidates, int i, int remain, List<Integer> list) {
        if (remain == 0) ans.add(new ArrayList(list));
        if (remain <= 0 || i >= candidates.length || candidates[i] <= 0) return;
        for (int j = 0; j * candidates[i] <= remain; j++) {
            for (int k = 0; k < j; k++) list.add(candidates[i]);
            dfs(candidates, i + 1, remain - j * candidates[i], list);
            for (int k = 0; k < j; k++) list.remove(list.size() - 1);
        }
    }
}