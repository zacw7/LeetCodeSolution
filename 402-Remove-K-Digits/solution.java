class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        while (k > 0) {
            if (k >= sb.length()) return "0";
            for (int i = 0; i < sb.length(); i++) {
                if (i == sb.length() - 1 || sb.charAt(i) > sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    break;
                }
            }
            while (sb.length() > 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
            if (sb.length() == 0) return "0";
            k--;
        }
        return sb.toString();
    }
}