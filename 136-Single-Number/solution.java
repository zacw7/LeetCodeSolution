class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int n : nums) xor = xor ^ n;
        return xor ^ 0;
    }
}