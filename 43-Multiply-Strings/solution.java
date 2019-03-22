class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (len1 == 0 || len2 == 0 || num1.equals("0") || num2.equals("0")) return "0";
        int[] digits1 = new int[len1], digits2 = new int[len2];
        for (int i = len1 - 1; i >= 0; i--) digits1[len1 - i - 1] = num1.charAt(i) - '0';
        for (int i = len2 - 1; i >= 0; i--) digits2[len2 - i - 1] = num2.charAt(i) - '0';
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0, len = len1 + len2 - 1; i < len; i++) {
            int digit = 0;
            for (int j = 0; j <= i; j++) {
                int c1 = j, c2 = i - j;
                if (c1 < len1 && c2 < len2) digit += digits1[c1] * digits2[c2];
            }
            sb.append((char) (digit + carry) % 10);
            carry = (digit + carry) / 10;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
}