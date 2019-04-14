class Solution {
    // T: O(N)
    // S: O(N)
    public String reverseWords(String s) {
        if (s == null) return "";
        String[] words = s.trim().replaceAll("( )+", " ").split(" ");
        if (words.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) sb.append(words[i]).append(" ");
        sb.append(words[0]);
        return sb.toString();
    }
}