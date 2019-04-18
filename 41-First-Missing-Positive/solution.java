class Solution {
    // T: O(n)
    // S: O(1)
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int lowerBound = Integer.MAX_VALUE, upperBound = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            } else {
                lowerBound = Math.min(lowerBound, nums[i]);
                upperBound = Math.max(upperBound, nums[i]);
            }
        }

        if (lowerBound > 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            int pos = Math.abs(nums[i]) - 1;
            if (pos < nums.length && nums[pos] > 0) {
                nums[pos] = -nums[pos];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return upperBound + 1;
    }
}