class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = 1_000_000_007;
        int sum = 0;
        int maxSub = 0;
        int minPrefix = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            maxSub = Math.max(maxSub, sum - minPrefix);
            minPrefix = Math.min(minPrefix, sum);
        }
        int cur = 0;
        int maxLeft = 0;
        int maxRight = sum;
        for (int n : arr) {
            cur += n;
            maxLeft = Math.max(maxLeft, cur);
            maxRight = Math.max(maxRight, sum - cur);
        }
        sum %= MOD;
        maxLeft %= MOD;
        maxRight %= MOD;
        if (k == 1) {
            return maxSub % MOD;
        }
        if (maxSub == sum) {
            return (sum % MOD) * k % MOD;
        }
        long res = 0;
        res = (long) maxLeft + (long)maxRight;
        res %= (long)MOD;
        if (sum > 0 && k > 2) {
            res += ((long) sum % (long)MOD) * (k - 2) % (long)MOD;
            res %= (long)MOD;
        }
        return Math.max(maxSub % MOD, (int) res);
    }
}