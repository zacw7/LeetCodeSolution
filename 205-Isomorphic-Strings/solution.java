class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> dict = new HashMap();
        for (int i = 0, len = s.length(); i < len; i++) {
            if (dict.keySet().contains(s.charAt(i))) {
                if (dict.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                if (dict.values().contains(t.charAt(i))) return false;
                dict.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}