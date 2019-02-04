class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character, Integer> charPos = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = charPos.getOrDefault(ch, -1);
            if (index == -1) charPos.put(ch, i);
            else charPos.put(ch, s.length());
        }
        int min = Collections.min(charPos.values());
        return (min == s.length()) ? -1 : min;
    }
}