class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) ans.add(nums[i]);
        }
        return ans;
    }
}