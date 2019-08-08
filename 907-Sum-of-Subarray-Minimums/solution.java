class Solution {
    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = A.length;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += (i - left[i]) * (right[i] - i) % MOD * A[i];
            sum %= MOD;
        }
        return sum;
    }
}