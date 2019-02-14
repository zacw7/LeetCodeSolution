class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> scores = new Stack();
        for (String r : ops) {
            if ("+".equals(r)) {
                int top = scores.pop();
                int score = scores.peek() + top;
                sum += score;
                scores.push(top);
                scores.push(score);
            } else if ("D".equals(r)) {
                int score = scores.peek() * 2;
                sum += score;
                scores.push(score);
            } else if ("C".equals(r)) {
                int top = scores.pop();
                sum -= top;
            } else {
                int score = Integer.valueOf(r);
                sum += score;
                scores.push(score);
            }
        }
        return sum;
    }
}