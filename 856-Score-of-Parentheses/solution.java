class Solution {
    // recursive
    // T: O(n) - the worst case: O(n^2)
    // S: O(1)
    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        return scoreHelper(S.toCharArray(), 0, S.length() - 1);
    }

    private int scoreHelper(char[] chars, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int curr = 0, count = 0, prev = 0;
        for (int i = start; i <= end; i++) {
            if (chars[i] == '(') {
                count++;
                if (count == 1) {
                    prev = i + 1;
                }
            } else {
                count--;
                if (count == 0) {
                    if (i == prev) {
                        curr += 1;
                    } else {
                        curr += scoreHelper(chars, prev, i - 1) * 2;
                    }
                }
            }
        }
        return curr;
    }
}