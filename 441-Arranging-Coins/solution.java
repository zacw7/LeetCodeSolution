class Solution {
    public int arrangeCoins(int n) {
        return (int)(2.0 * Math.sqrt((double)n / 2  + 1.0 / 16) - 1.0 / 2);
    }
}