class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charStore = new HashMap();
        for (char c : magazine.toCharArray()) {
            charStore.put(c, charStore.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            int count = charStore.getOrDefault(c, 0);
            if (count > 0) {
                charStore.put(c, count - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}