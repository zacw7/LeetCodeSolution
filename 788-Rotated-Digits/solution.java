class Solution {
    public int rotatedDigits(int N) {
        Set<Integer> goodNums = new HashSet(Arrays.asList(2, 5, 6, 9));
        Set<Integer> netrualNums = new HashSet(Arrays.asList(0, 1, 8));
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int n = i;
            boolean isGoodNum = false;
            while (n > 0) {
                int digit = n % 10;
                if (goodNums.contains(n)) {
                    isGoodNum = true;
                    break;
                }
                if (goodNums.contains(digit)) {
                    isGoodNum = true;
                } else if (netrualNums.contains(digit)) {
                    ;
                } else {
                    isGoodNum = false;
                    break;
                }
                n /= 10;
            }
            if (isGoodNum) {
                goodNums.add(i);
                count++;
            }
        }
        return count;
    }
}