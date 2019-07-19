class Solution {
    public String boldWords(String[] words, String S) {
        boolean[] isBold = new boolean[S.length()];
        for (String w : words) {
            int i = S.indexOf(w);
            while (i >= 0) {
                for (int j = 0; j < w.length(); j++) {
                    isBold[i + j] = true;
                }
                i = S.indexOf(w, i + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (isBold[i]) {
                if (i == 0 || !isBold[i - 1]) {
                    sb.append("<b>");
                }
            }
            sb.append(S.charAt(i));
            if (isBold[i]) {
                if (i == S.length() - 1 || !isBold[i + 1]) {
                    sb.append("</b>");
                }
            }
        }
        return sb.toString();
    }
}