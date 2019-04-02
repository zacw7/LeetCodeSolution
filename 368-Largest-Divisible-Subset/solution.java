class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) return new ArrayList();
        Arrays.sort(nums);
        List<Integer>[] memo = new List[nums.length];
        for (int i = 0; i < memo.length; i++) memo[i] = new ArrayList();
        List<Integer> max = memo[0];
        for (int i = 0; i < memo.length; i++) {
            memo[i].add(nums[i]);
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % memo[j].get(memo[j].size() - 1) == 0
                        && memo[j].size() + 1 > memo[i].size()) {
                    memo[i] = new ArrayList(memo[j]);
                    memo[i].add(nums[i]);
                }
            }
            if (memo[i].size() > max.size()) max = memo[i];
        }
        return max;
    }
}