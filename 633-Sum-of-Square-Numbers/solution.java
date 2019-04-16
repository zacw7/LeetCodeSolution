class Solution {
    // T: O(c) - up to sqrt(c)
    // S: O(1)
    public boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        // check if a == b
        if (c % 2 == 0) {
            int r = (int) Math.sqrt(c / 2);
            if (r * r == c / 2) {
                return true;
            }
        }
        for (int a = 1; a <= Math.sqrt(c); a++) {
            int remain = c - a * a;
            int root = (int) Math.sqrt(remain);
            if (root * root == remain) {
                return true;
            }
        }
        return false;
    }
}