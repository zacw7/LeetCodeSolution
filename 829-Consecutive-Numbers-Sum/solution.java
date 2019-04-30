class Solution {
    public int consecutiveNumbersSum(int N) {
        if (N <= 0) {
            return 0;
        }

        int count = 1;
        for (int i = 2; N - i * i / 2 > 0; i++) {
            if ((N % i) == 0) {
                int center = N / i;
                if (i % 2 == 1) {
                    count++;
                }
            } else if ((N * 2) % i == 0 && (i % 2 == 0)) {
                count++;
            }
        }

        return count;
    }
}