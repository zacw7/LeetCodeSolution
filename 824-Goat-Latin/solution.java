class Solution {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) {
            char ch = words[i].charAt(0);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                words[i] = words[i] + "ma";
            } else {
                words[i] = words[i].substring(1) + words[i].substring(0, 1) + "ma";
            }
            for (int j = 0; j <= i; j++) {
                words[i] = words[i] + "a";
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String w : words) {
            sb.append(w).append(' ');
        }
        return sb.toString().trim();
    }
}