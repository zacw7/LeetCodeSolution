class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1;
             i >= 0 || j >= 0 || carry > 0; i--, j--) {
            int d = carry;
            if (i >= 0 && a.charAt(i) == '1') {
                d++;
            }
            if (j >= 0 && b.charAt(j) == '1') {
                d++;
            }
            sum.insert(0, (char)('0' + d % 2));
            carry = d / 2;
        }
        return sum.toString();
    }
}