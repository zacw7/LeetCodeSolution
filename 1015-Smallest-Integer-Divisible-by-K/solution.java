class Solution {
    public int smallestRepunitDivByK(int K) {
        if (K == 1 || K == 3) return K;
        if (K % 2 == 0 && K % 5 == 0) return -1;
        int ans = 0, N = 0;
        int t = 100000;
        while (t-- > 0) {
            N = N * 10 + 1;
            N %= K;
            ans++;
            if (N % K == 0) return ans;
        }
        return -1;
    }
}