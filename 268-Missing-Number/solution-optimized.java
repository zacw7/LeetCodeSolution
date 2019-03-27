class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        return n * (n + 1) / 2 - sum;
    }
}