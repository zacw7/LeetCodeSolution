class Solution {
    // count cores
    // T: O(n)
    // S: O(1)
    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                bal++;
            } else {
                bal--;
                if (S.charAt(i - 1) == '(') {
                    ans += 1 << bal;
                }
            }
        }

        return ans;
    }
}