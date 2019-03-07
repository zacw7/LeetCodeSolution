class Solution {
    public char findTheDifference(String s, String t) {
        int[] compare = new int[26];
        for (char ch : s.toCharArray()) {
            compare[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            compare[ch - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (compare[i] != 0) return (char) ('a' + i);
        }
        return 0;
    }
}