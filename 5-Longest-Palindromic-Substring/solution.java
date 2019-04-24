class Solution {
    // T: O(n^2)
    // S: O(n)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append('#');
        }
        int len = 0;
        String res = "";
        for (int i = 0; i < sb.length(); i++) {
            int cur = 1;
            while (i - cur > 0 && i + cur < sb.length() && sb.charAt(i - cur) == sb.charAt(i + cur)) {
                cur++;
            }
            if (cur > len) {
                len = cur;
                res = sb.substring(i - cur + 1, i + cur);
            }
        }
        return res.replaceAll("#", "");
    }
}