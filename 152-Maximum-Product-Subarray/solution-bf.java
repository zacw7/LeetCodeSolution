class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int cur = nums[i];
            max = Math.max(max, cur);
            for (int j = i + 1; j < nums.length; j++) {
                cur *= nums[j];
                if (nums[i] == 0) break;
                max = Math.max(max, cur);
            }
        }
        return max;
    }
}