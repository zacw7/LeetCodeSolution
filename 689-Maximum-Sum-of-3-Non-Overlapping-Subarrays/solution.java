class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int N = nums.length - k + 1;
        int[] sums = new int[N];
        int cur = 0;
        for (int i = 0; i < k - 1; i++) {
            cur += nums[i];
        }
        for (int i = 0; i < N; i++) {
            cur += nums[i + k - 1];
            sums[i] = cur;
            cur -= nums[i];
        }
        int[] left = new int[N];
        for (int best = -1, i = 0; i < N; i++) {
            if (i - k >= 0 && (best == -1 || sums[i - k] > sums[best])) {
                best = i - k;
            }
            left[i] = best;
        }
        int[] right = new int[N];
        for (int best = N, i = N - 1; i >= 0; i--) {
            if (i + k < N && (best == N || sums[i + k] >= sums[best])) {
                best = i + k;
            }
            right[i] = best;
        }
        int[] res = new int[3];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (left[i] >= 0 && right[i] < N) {
                int curSum = sums[left[i]] + sums[i] + sums[right[i]];
                if (curSum > maxSum) {
                    maxSum = curSum;
                    res = new int[]{left[i], i, right[i]};
                }
            }
        }
        return res;
    }
}