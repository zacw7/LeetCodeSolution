class Solution {
    public int tribonacci(int n) {
        int[] fib = new int[38];
        fib[1] = fib[2] = 1;
        for (int i = 3; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2] + fib[i - 3];
        }
        return fib[n];
    }
}