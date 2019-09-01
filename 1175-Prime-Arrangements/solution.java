class Solution {
    public int numPrimeArrangements(int n) {
        if (n <= 2) {
            return 1;
        }
        int MOD = 1_000_000_007;
        int prime = primeCount(n);
        int n_prime = n - prime;
        long res = 1;
        while (prime > 1) {
            res *= prime--;
            res %= MOD;
        }
        while (n_prime > 1) {
            res *= n_prime--;
            res %= MOD;
        }
        return (int) res;
    }

    private int primeCount(int N) {
        int count = 0;
        for (int n = 2; n <= N; n++) {
            if (isPrime(n)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}