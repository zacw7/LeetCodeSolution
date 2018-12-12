class Solution {
    public int minMoves(int[] nums) {
        int sum = 0, min = nums[0];
        for (int n : nums) {
            sum += n;
            if (n < min) min = n;
        }
        return sum - nums.length * min;
    }
}