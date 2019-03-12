class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length() || s.length() == 0) return false;
        Map<Character, Character> dict = new HashMap();
        for (int i = 1; i < s.length(); i++) {
            if (dict.keySet().contains(s.charAt(i))) {
                if (!dict.get(s.charAt(i)).equals(t.charAt(i))) return false;
            } else {
                dict.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}