class Solution {
    // T: O(n)
    // S: O(n)
    public int bulbSwitch(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            count++;
        }
        return count;
    }
}