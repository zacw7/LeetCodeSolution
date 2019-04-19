class Solution {
    // T: O(1)
    // S: O(1)
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n - 1) & n) == 0;
    }
}