class Solution {
    public String addStrings(String num1, String num2) {
        int idx1 = num1.length() - 1, idx2 = num2.length() - 1;
        int carryBit = 0;
        int offset = '0' - 0;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0) {
            int num = carryBit;
            if (idx1 >= 0) num += num1.charAt(idx1--) - offset;
            if (idx2 >= 0) num += num2.charAt(idx2--) - offset;
            sb.append((char)(num % 10 + offset));
            carryBit = num / 10;
        }
        if (carryBit == 1) sb.append('1');
        return sb.reverse().toString();
    }
}