class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        if (n == 2) return 2;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += numTrees(i) * numTrees(n - i - 1);
        }
        return count;
    }
}