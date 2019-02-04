class Solution {
    public String reverseStr(String s, int k) {
        if (k <= 1) return s;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i * k < s.length(); i += 2) {
            int left = i * k, right = i * k + k - 1;
            if (right >= s.length()) right = s.length() - 1;
            while (left < right) {
                sb.setCharAt(left, s.charAt(right));
                sb.setCharAt(right, s.charAt(left));
                left++;
                right--;
            }
        }
        return sb.toString();
    }
}