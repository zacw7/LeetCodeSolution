class Solution {
    List<List<Integer>> ans;
    Set<String> seen;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList();
        seen = new HashSet();
        dfs(candidates, 0, target, new ArrayList());
        return ans;
    }

    private void dfs(int[] candidates, int i, int target, List<Integer> list) {
        if (target == 0) {
            List<Integer> comb = new ArrayList(list);
            Collections.sort(comb);
            if (!seen.contains(comb.toString())) ans.add(comb);
            seen.add(comb.toString());
        }
        if (target <= 0 || i >= candidates.length) return;
        list.add(candidates[i]);
        dfs(candidates, i + 1, target - candidates[i], list);
        list.remove(list.size() - 1);
        dfs(candidates, i + 1, target, list);
    }
}