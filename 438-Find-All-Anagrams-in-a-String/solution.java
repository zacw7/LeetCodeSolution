class Solution {
    // T: O(nm) - n, m is the lengths of s, p respectively
    // S: O(1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList();
        if (s.length() < p.length()) return ans;
        int[] pattern = new int[26];
        int[] source = new int[26];
        for (char c : p.toCharArray()) pattern[c - 'a']++;
        for (int i = 0; i < p.length(); i++) source[s.charAt(i) - 'a']++;
        if (isValid(source, pattern)) ans.add(0);
        for (int i = p.length(); i < s.length(); i++) {
            source[s.charAt(i) - 'a']++;
            source[s.charAt(i - p.length()) - 'a']--;
            if (isValid(source, pattern)) ans.add(i -  p.length() + 1);
        }
        return ans;
    }

    private boolean isValid(int[] s, int[] p) {
        for (int i = 0; i < 26; i++) {
            if (s[i] < p[i]) return false;
        }
        return true;
    }
}