class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        permuteHelper(nums, 0, ans, new HashSet());
        return ans;
    }

    private void permuteHelper(int[] nums, int i, List<List<Integer>> ans, Set<String> seen) {
        if (i == nums.length - 1) {
            String key = Arrays.toString(nums);
            if (!seen.contains(key)) {
                seen.add(key);
                List<Integer> permutation = new ArrayList();
                for (int n : nums) {
                    permutation.add(n);
                }
                ans.add(permutation);
            }
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            permuteHelper(nums, i + 1, ans, seen);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}