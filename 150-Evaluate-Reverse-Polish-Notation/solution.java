class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int num1 = nums.pop(), num2 = nums.pop();
                nums.push(num1 + num2);
            } else if ("-".equals(token)) {
                int num1 = nums.pop(), num2 = nums.pop();
                nums.push(num2 - num1);
            } else if ("*".equals(token)) {
                int num1 = nums.pop(), num2 = nums.pop();
                nums.push(num1 * num2);
            } else if ("/".equals(token)) {
                int num1 = nums.pop(), num2 = nums.pop();
                nums.push(num2 / num1);
            } else {
                nums.push(Integer.valueOf(token));
            }
        }
        return nums.pop();
    }
}