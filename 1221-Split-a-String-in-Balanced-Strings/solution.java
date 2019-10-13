class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int L = 0, R = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                L++;
            } else {
                R++;
            }
            if (L > 0 && L == R) {
                count++;
                L = R = 0;
            }
        }
        return count;
    }
}