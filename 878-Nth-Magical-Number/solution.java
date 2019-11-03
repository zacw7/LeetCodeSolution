class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int MOD = 1_000_000_007;
        if (A < B) {
            return nthMagicalNumber(N, B, A);
        }
        if (A == 1 || B == 1) {
            return N;
        }
        int C = A * B / gcd(A, B);
        long lo = 1, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (mid / A + mid / B - mid / C < N) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return (int) (lo % MOD);
    }

    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}