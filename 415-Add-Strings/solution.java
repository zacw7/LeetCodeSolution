class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int cur = carry;
            if (i >= 0) {
                cur += num1.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                cur += num2.charAt(j) - '0';
                j--;
            }
            sb.insert(0, (char) (cur % 10 + '0'));
            carry = cur / 10;
        }
        return sb.toString();
    }
}