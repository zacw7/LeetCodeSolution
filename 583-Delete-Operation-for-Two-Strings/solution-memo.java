class Solution {
    // recursion with memo
    // O(MN)
    // O(MN)
    private Map<Integer, Integer> cache = new HashMap();
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0) {
            return Math.max(word1.length(), word2.length());
        }
        int key = word1.length() * 500 + word2.length();
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int res = 0;
        if (word1.charAt(0) == word2.charAt(0)) {
            res = minDistance(word1.substring(1), word2.substring(1));
        } else {
            res = 1 + Math.min(minDistance(word1.substring(1), word2),
                    minDistance(word1, word2.substring(1)));
        }
        cache.put(key, res);
        return res;
    }
}