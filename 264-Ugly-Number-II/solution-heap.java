class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 1) return n;
        TreeSet<Long> heap = new TreeSet();
        heap.add(1L);
        while (--n > 0) {
            long cur = heap.first();
            heap.remove(cur);
            heap.add(cur * 2);
            heap.add(cur * 3);
            heap.add(cur * 5);
        }
        return heap.first().intValue();
    }
}