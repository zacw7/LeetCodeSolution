class Solution {
    // TC: O(N + NLogN) - N is the number of digits of n
    // SC: O(N) - N is the number of digits of n
    public int nextGreaterElement(int n) {
        int LEN = String.valueOf(n).length();
        int[] digits = new int[LEN];
        int[] lastSeen = new int[10];
        Arrays.fill(lastSeen, -1);
        for (int i = LEN - 1; i >= 0; i--) {
            int d = n % 10;
            digits[i] = d;
            if (lastSeen[d] == -1) {
                lastSeen[d] = i;
            }
            n /= 10;
        }
        int idx = LEN - 2, next = -1;
        while (idx >= 0) {
            int d = digits[idx];
            for (int num = d + 1; num < 10; num++) {
                if (lastSeen[num] > idx) {
                    next = lastSeen[num];
                    break;
                }
            }
            if (next >= 0) {
                break;
            }
            idx--;
        }
        if (idx < 0) {
            return -1;
        }
        int tmp = digits[idx];
        digits[idx] = digits[next];
        digits[next] = tmp;
        Arrays.sort(digits, idx + 1, LEN);
        int res = 0;
        for (int d : digits) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && d > 7)) {
                return -1;
            }
            res *= 10;
            res += d;
        }
        return res;
    }
}