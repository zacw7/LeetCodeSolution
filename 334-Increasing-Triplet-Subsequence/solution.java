class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n == n1 || n == n2) {
                continue;
            }
            if (n > n2) {
                return true;
            }

            if (n < n1) {
                n1 = n;
            } else if (n < n2) {
                n2 = n;
            }
        }

        return false;
    }
}