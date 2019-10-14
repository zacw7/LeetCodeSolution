class Solution {

    // Reservoir Sampling
    private int[] nums;
    private Random rand;

    // TC: O(1)
    public Solution(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    // TC: O(n)
    public int pick(int target) {
        int count = 0;
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if (rand.nextInt(count) == 0) {
                    idx = i;
                }
            }
        }
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */