class Solution {
    // T: O(logn)
    // S: O(1)
    public int lastRemaining(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int ans = 1, delta = 1;
        int round = 1, num = n;
        while (n > 1) {
            if (round % 2 == 1 || n % 2 == 1) {
                // remove the first element
                ans = ans + delta;
            }   // else: keep the first element
            n /= 2;
            round++;
            delta *= 2;
        }
        return ans;
    }
}