class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1, hi = 1_000_000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (sumAfterDiv(nums, mid) > threshold) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private int sumAfterDiv(int[] nums, int div) {
        int sum = 0;
        for (int n : nums) {
            sum += n / div;
            if (n % div > 0) {
                sum += 1;
            }
        }
        return sum;
    }
}