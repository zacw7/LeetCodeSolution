class Solution {
    // recursion
    // O(2^(NM))
    // O(N+M)
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        if (word1.charAt(0) == word2.charAt(0)) {
            return minDistance(word1.substring(1), word2.substring(1));
        } else {
            return 1 + Math.min(minDistance(word1.substring(1), word2),
                    minDistance(word1, word2.substring(1)));
        }
    }
}