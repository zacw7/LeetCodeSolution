class Solution {
    // stack
    // T: O(n)
    // S: O(n)
    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }

        Stack<Integer> scores = new Stack();
        scores.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(') {
                scores.push(0);
            } else {
                int curr = scores.pop(), prev = scores.pop();
                if (curr == 0) {
                    scores.push(prev + 1);
                } else {
                    scores.push(curr * 2 + prev);
                }
            }
        }

        return scores.pop();
    }
}