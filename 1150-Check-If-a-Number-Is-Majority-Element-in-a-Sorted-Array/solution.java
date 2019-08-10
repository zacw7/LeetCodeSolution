class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int count = 0;
        for (int n : nums) {
            if (n == target) {
                count++;
            }
        }
        return count * 2 > nums.length;
    }
}