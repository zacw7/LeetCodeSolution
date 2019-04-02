class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return dp(s, wordDict);
    }

    private boolean dp(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        for (String word : wordDict) {
            if (s.length() >= word.length()
                    && word.equals(s.substring(0, word.length()))
                    && dp(s.substring(word.length(), s.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }
}