class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] nums = new int[rowIndex + 1];
        nums[0] = 1;
        for (int r = 1; r <= rowIndex; r++) {
            int prev = nums[0];
            for (int i = 1; i <= r; i++) {
                int tmp = nums[i];
                nums[i] = nums[i] + prev;
                prev = tmp;
            }
        }
        List<Integer> ans = new ArrayList(rowIndex);
        for (int n : nums) ans.add(n);
        return ans;
    }
}