class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        boolean[] seen = new boolean[n];
        seen[0] = seen[1] = true;
        for (int i = 2, bound = (int) Math.sqrt(n); i <= bound; i++) {
            if (seen[i] == false) {
                for (int t = 2; i * t < n; t++) {
                    seen[i * t] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (seen[i] == false) count++;
        }
        return count;
    }
}