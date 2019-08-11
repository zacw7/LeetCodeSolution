class Solution {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        String encode = "";
        for (int i = 0; i < words.length; i++) {
            if (!encode.contains(words[i] + "#")) {
                encode += words[i] + "#";
            }
        }
        return encode.length();
    }
}