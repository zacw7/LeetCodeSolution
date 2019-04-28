class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> nums = new Stack();
        nums.push(0);
        Stack<Integer> signs = new Stack();
        signs.push(1);
        int layer = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num *= 10;
                    num += s.charAt(i) - '0';
                }
                nums.push(num);
            } else if (c == '+') {
                signs.push(1);
            } else if (c == '-') {
                signs.push(-1);
            } else if (c == '(') {
                layer++;
            } else if (c == ')') {
                layer--;
            }
            if (nums.size() > layer) {
                int n2 = signs.pop() * nums.pop();
                int n1 = nums.pop();
                nums.push(n1 + n2);
            }
        }
        return nums.peek();
    }

}