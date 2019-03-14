class Solution {
    public int countPrimeSetBits(int L, int R) {
        Set<Integer> primes = new HashSet();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        primes.add(13);
        primes.add(17);
        primes.add(19);
        primes.add(23);
        primes.add(29);
        primes.add(31);
        int count = 0;
        for (int i = L; i <= R; i++) {
            int n = i;
            int set = 0;
            while (n > 0) {
                n = n & (n - 1);
                set++;
            }
            if (primes.contains(set)) count++;
        }
        return count;
    }
}