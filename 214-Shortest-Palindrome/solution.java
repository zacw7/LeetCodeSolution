class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        int center = sb.length() / 2;
        for (int i = center; i > 1; i--) {
            if (isPalindrome(sb, i)) {
                sb.insert(0, generateAppendix(sb, i));
                return sb.toString().replaceAll("#", "");
            }
        }
        sb.insert(0, generateAppendix(sb, 1));
        return sb.toString().replaceAll("#", "");
    }

    private boolean isPalindrome(StringBuilder sb, int i) {
        for (int j = 1; i - j >= 0; j++) {
            if (sb.charAt(i - j) != sb.charAt(i + j)) {
                return false;
            }
        }
        return true;
    }

    private String generateAppendix(StringBuilder sb, int i) {
        StringBuilder appendix = new StringBuilder();
        for (int j = sb.length() - 1; j > 2 * i; j--) {
            appendix.append(sb.charAt(j));
        }
        return appendix.toString();
    }
}