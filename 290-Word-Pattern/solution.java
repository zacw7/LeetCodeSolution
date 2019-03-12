class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> patternMap = new HashMap();
        for (int i = 0; i < words.length; i++) {
            if (patternMap.containsKey(pattern.charAt(i))) {
                if (!patternMap.get(pattern.charAt(i)).equals(words[i])) return false;
            } else {
                if (patternMap.containsValue(words[i])) return false;
                patternMap.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }
}