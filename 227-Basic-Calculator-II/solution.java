class Solution {
    public int calculate(String s) {
        Deque<Integer> nums = new LinkedList();
        Deque<Character> tokens = new LinkedList();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    num *= 10;
                    num += s.charAt(i) - '0';
                }
                if (!tokens.isEmpty() && (tokens.peekLast() == '*' || tokens.peekLast() == '/')) {
                    int prev = nums.pollLast();
                    if (tokens.peekLast() == '*') {
                        num = prev * num;
                    } else {
                        num = prev / num;
                    }
                    tokens.pollLast();
                }
                nums.offerLast(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                tokens.offerLast(c);
            }
        }
        while (!tokens.isEmpty()) {
            int n1 = nums.pollFirst(), n2 = nums.pollFirst();
            if (tokens.peek() == '+') {
                nums.offerFirst(n1 + n2);
            } else if (tokens.peek() == '-') {
                nums.offerFirst(n1 - n2);
            }
            tokens.pollFirst();
        }
        return nums.peek();
    }
}