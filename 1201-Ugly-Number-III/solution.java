class Solution {
    long ab, bc, ac, abc;
    public int nthUglyNumber(int n, int a, int b, int c) {
        int lo = 1, hi = Integer.MAX_VALUE;
        ab = lcm((long)a, (long)b);
        bc = lcm((long)b, (long)c);
        ac = lcm((long)a, (long)c);
        abc = lcm((long)a, bc);
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long cnt = uglyCount((long)mid, (long)a, (long)b, (long)c);
            System.out.println(lo + " / " + hi + " / " + mid + " : " + cnt);
            if (cnt < n) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private long uglyCount(long num, long a, long b, long c) {
        return (num / a) + (num / b) + (num / c)
                - num / ab - num / bc - num / ac
                + num / abc;
    }

    private long lcm(long a, long b) {
        if (a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        return a * b / gcd(a, b);
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}