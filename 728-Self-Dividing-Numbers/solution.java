class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList();
        for (int num = left; num <= right; num++) {
            if (isSelfDividingNumber(num)) ans.add(num);
        }
        return ans;
    }

    private boolean isSelfDividingNumber(int num) {
        int cur = num, divisor = cur % 10;
        while (cur != 0) {
            if (divisor == 0 || num % divisor > 0) return false;
            cur /= 10;
            divisor = cur % 10;
        }
        return true;
    }
}