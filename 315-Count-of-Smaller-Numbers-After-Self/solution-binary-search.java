class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList();
        List<Integer> list = new ArrayList();
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(0, insertAndCount(list, nums[i]));
        }
        return res;
    }

    private int insertAndCount(List<Integer> list, int n) {
        if (list.isEmpty() || n <= list.get(0)) {
            list.add(0, n);
            return 0;
        }
        if (n > list.get(list.size() - 1)) {
            list.add(n);
            return list.size() - 1;
        }
        // find the first smaller element
        int lo = 0, hi = list.size() - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) >= n) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        if (list.get(hi) < n) {
            list.add(hi + 1, n);
            return hi + 1;
        } else {
            list.add(lo + 1, n);
            return lo + 1;
        }
    }
}