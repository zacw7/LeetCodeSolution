class Solution {
    public String toLowerCase(String str) {
        int offset = 'A' - 'a';
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <='Z') {
                sb.append((char)(ch - offset));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}