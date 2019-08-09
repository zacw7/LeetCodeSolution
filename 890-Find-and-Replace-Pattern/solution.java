class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList();
        for (String word : words) {
            if (word.length() != pattern.length()) {
                continue;
            }
            boolean isMatch = true;
            Map<Character, Character> wordToPattern = new HashMap();
            Map<Character, Character> patternToWord = new HashMap();
            for (int i = 0; i < pattern.length(); i++) {
                char w = word.charAt(i), p = pattern.charAt(i);
                wordToPattern.putIfAbsent(w, p);
                patternToWord.putIfAbsent(p, w);
                isMatch = (p == wordToPattern.get(w) && w == patternToWord.get(p));
                if (!isMatch) {
                    break;
                }
            }
            if (isMatch) {
                res.add(word);
            }
        }
        return res;
    }
}