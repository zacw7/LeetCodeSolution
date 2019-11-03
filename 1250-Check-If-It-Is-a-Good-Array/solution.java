class Solution {
    public boolean isGoodArray(int[] nums) {
        int div = nums[0];
        for (int i = 1; i < nums.length; i++) {
            div = gcd(div, nums[i]);
        }
        return div == 1;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}