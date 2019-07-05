class Solution {
    // bit manipulation
    // TC: O(n)
    // SC: O(1)
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int n : nums) {
            ans ^= n;
        }
        return ans;
    }
}