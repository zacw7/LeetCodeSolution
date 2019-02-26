class Solution {
    public int fib(int N) {
        if (N <= 1) return N;
        int app1 = 0, app2 = 1;
        for (int i = 1; i < N; i++) {
            int sum = app1 + app2;
            app1 = app2;
            app2 = sum;
        }
        return app2;
    }
}