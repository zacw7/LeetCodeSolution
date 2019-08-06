class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList();
        for (int n : nums) {
            count += countGreater(list, (long) n * 2);
            insertInSortedList(list, n);
        }
        return count;
    }

    private int countGreater(List<Integer> list, long x) {
        // find the first greater element
        if (list.isEmpty() || list.get(list.size() - 1) <= x) {
            return 0;
        }
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return list.size() - lo;
    }

    private void insertInSortedList(List<Integer> list, int x) {
        if (list.isEmpty() || list.get(list.size() - 1) <= x) {
            list.add(x);
            return;
        }
        // find the first greater element index
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) <= x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        list.add(lo, x);
    }
}