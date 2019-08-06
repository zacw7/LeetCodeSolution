class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // evenMove -> even-index is less
        // oddMove -> odd-index is less
        int evenMove = 0, oddMove = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (i > 0) {
                cur = Math.min(cur, nums[i - 1] - 1);
            }
            if (i + 1 < nums.length) {
                cur = Math.min(cur, nums[i + 1] - 1);
            }
            if (cur < nums[i]) {
                if (i % 2 == 1) {
                    // odd index
                    oddMove += nums[i] - cur;
                } else {
                    // even index
                    evenMove += nums[i] - cur;
                }
            }
        }
        return Math.min(evenMove, oddMove);
    }
}