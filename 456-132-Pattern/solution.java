class Solution {
    // min array + treeset
    // TC: O(N + NlogN)
    // SC: O(N)
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] minLeft = new int[nums.length];
        minLeft[0] = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            minLeft[i] = Math.min(nums[i - 1], minLeft[i - 1]);
        }
        TreeSet<Integer> treeSet = new TreeSet();
        for (int i = nums.length - 1; i > 0; i--) {
            Integer maxRight = treeSet.lower(nums[i]);
            treeSet.add(nums[i]);
            if (nums[i] > minLeft[i] && maxRight != null && maxRight > minLeft[i]) {
                return true;
            }
        }
        return false;
    }
}