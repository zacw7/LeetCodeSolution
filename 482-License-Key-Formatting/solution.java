class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (char ch : S.toUpperCase().toCharArray()) {
            if (ch != '-') sb.append(ch);
        }
        for (int i = sb.length() - K; i > 0; i -= K) sb.insert(i, '-');
        return sb.toString();
    }
}