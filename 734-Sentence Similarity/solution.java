class Solution {
    // Hash Table
    // T: O(n)
    // S: O(n)
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null || words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> pairMap = new HashMap();
        for (String[] pair : pairs) {
            Set<String> pairSet = pairMap.getOrDefault(pair[0], new HashSet());
            pairSet.add(pair[1]);
            pairMap.put(pair[0], pairSet);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) {
                continue;
            } else {
                if (pairMap.containsKey(words1[i]) && pairMap.get(words1[i]).contains(words2[i])) {
                    continue;
                }
                if (pairMap.containsKey(words2[i]) && pairMap.get(words2[i]).contains(words1[i])) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}