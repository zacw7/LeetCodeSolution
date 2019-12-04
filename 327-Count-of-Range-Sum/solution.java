class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        List<Long> list = new ArrayList();
        list.add(0L);
        long sum = 0;
        int res = 0;
        for (int n : nums) {
            sum += n;
            res += search(list, sum - upper, sum - lower);
            insert(list, sum);
        }
        return res;
    }

    private int search(List<Long> list, long n1, long n2) {
        int lo = 0, hi = list.size() - 1;
        if (list.get(hi) < n1 || list.get(lo) > n2) {
            return 0;
        }
        // find the i which is the first list.get(i) >= n1
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < n1) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int tmp = lo;
        // find the i which is the last list.get(i) <= n2
        lo = 0;
        hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2 + 1;
            if (list.get(mid) > n2) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo - tmp + 1;
    }

    private void insert(List<Long> list, long num) {
        int lo = 0, hi = list.size() - 1;
        if (num >= list.get(hi)) {
            list.add(num);
            return;
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (num > list.get(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        list.add(lo, num);
    }
}