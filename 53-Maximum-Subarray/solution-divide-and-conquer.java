class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Result res = maxSubArray(nums, 0, nums.length - 1);
        return res.localMax;
    }

    private Result maxSubArray(int[] nums, int l, int r) {
        if (l == r) {
            return new Result(nums[l], nums[r], nums[l], nums[l]);
        }
        int mid = l + (r - l) / 2;
        Result resLeft = maxSubArray(nums, l, mid);
        Result resRight = maxSubArray(nums, mid + 1, r);
        return new Result(Math.max(resLeft.leftMax, resLeft.sum + resRight.leftMax),
                Math.max(resRight.rightMax, resLeft.rightMax + resRight.sum),
                Math.max(resLeft.rightMax + resRight.leftMax, Math.max(resLeft.localMax, resRight.localMax)),
                resLeft.sum + resRight.sum);
    }

    class Result {
        int leftMax, rightMax, localMax, sum;

        Result(int leftMax, int rightMax, int localMax, int sum) {
            this.leftMax = leftMax;
            this.rightMax = rightMax;
            this.localMax = localMax;
            this.sum = sum;
        }
    }
}