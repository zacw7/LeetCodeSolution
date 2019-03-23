class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        Set<Integer> seen = new HashSet();
        List<List<Integer>> cur = new ArrayList();
        cur.add(new ArrayList());
        res.addAll(cur);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = res;
            if (seen.contains(nums[i])) tmp = cur;
            cur = new ArrayList();
            for (List<Integer> comb : tmp) {
                List<Integer> subset = new ArrayList(comb);
                subset.add(nums[i]);
                cur.add(subset);
            }
            seen.add(nums[i]);
            res.addAll(cur);
        }
        return res;
    }
}