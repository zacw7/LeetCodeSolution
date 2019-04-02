class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 6) return n;
        Queue<Long> ugly2 = new LinkedList();
        Queue<Long> ugly3 = new LinkedList();
        Queue<Long> ugly5 = new LinkedList();
        ugly2.add(2L);
        ugly3.add(3L);
        ugly5.add(5L);
        while (--n > 1) {
            long cur = Math.min(ugly2.peek(), Math.min(ugly3.peek(), ugly5.peek()));
            if (cur == ugly2.peek()) {
                ugly2.poll();
                ugly2.add(cur * 2);
                ugly3.add(cur * 3);
                ugly5.add(cur * 5);
            } else if (cur == ugly3.peek()) {
                ugly3.poll();
                ugly3.add(cur * 3);
                ugly5.add(cur * 5);
            } else {
                ugly5.poll();
                ugly5.add(cur * 5);
            }
        }
        return (int) Math.min(ugly2.peek(), Math.min(ugly3.peek(), ugly5.peek()));
    }
}