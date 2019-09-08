class Solution {
    public int maximumSum(int[] arr) {
        int N = arr.length;
        int[] maxEndWith = new int[N];
        int max = arr[0];
        maxEndWith[0] = max;
        for (int i = 1; i < N; i++) {
            maxEndWith[i] = Math.max(arr[i], maxEndWith[i - 1] + arr[i]);
        }
        int[] maxStartWith = new int[N];
        max = maxStartWith[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            maxStartWith[i] = Math.max(arr[i], maxStartWith[i + 1] + arr[i]);
        }
        for (int i = 0; i < N; i++) {
            max = Math.max(max, Math.max(maxEndWith[i], maxStartWith[i]));
            if (i > 0 && i + 1 < N) {
                max = Math.max(max, maxEndWith[i - 1] + maxStartWith[i + 1]);
            }
        }
        return max;
    }
}