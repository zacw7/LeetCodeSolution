class Solution {
    // T: O(n*k*logn) - k is the size of primes
    // S: O(kn) - k is the size of primes
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 1) return n;
        TreeSet<Long> heap = new TreeSet();
        heap.add(1L);
        while (--n > 0) {
            long cur = heap.first();
            heap.remove(cur);
            for (int p : primes) heap.add(cur * p);
        }
        return heap.first().intValue();
    }
}