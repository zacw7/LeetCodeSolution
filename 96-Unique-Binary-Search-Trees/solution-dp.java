class Solution {
    public int numTrees(int n) {
        if (n <= 2) return n;
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        count[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int k = 0; k < i; k++) {
                count[i] += count[k] * count[i - k - 1];
            }
        }
        return count[n];
    }
}