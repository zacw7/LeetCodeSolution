class Solution {
    public int maximumSwap(int num) {
        if (num < 10) {
            return num;
        }
        List<Integer> digits = new ArrayList();
        int n = num;
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        int maxIndex = 0, swap1 = 0, swap2 = 0;
        for (int i = 1; i < digits.size(); i++) {
            if (digits.get(i) > digits.get(maxIndex)) {
                maxIndex = i;
            } else if (digits.get(i) < digits.get(maxIndex)){
                swap1 = i;
                swap2 = maxIndex;
            }
        }
        if (swap1 > 0) {
            int tmp = digits.get(swap1);
            digits.set(swap1, digits.get(swap2));
            digits.set(swap2, tmp);
            num = 0;
            for (int i = digits.size() - 1; i >= 0; i--) {
                num *= 10;
                num += digits.get(i);
            }
        }
        return num;
    }
}