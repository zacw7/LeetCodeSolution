class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        return Integer.toString(n, 3).matches("^10*$");
    }
}