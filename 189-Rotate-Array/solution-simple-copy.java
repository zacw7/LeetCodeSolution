class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) return;
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        System.arraycopy(tmp, nums.length - k, nums, 0, k);
        System.arraycopy(tmp, 0, nums, k, nums.length - k);
    }
}