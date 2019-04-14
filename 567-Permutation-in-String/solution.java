class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] source = new int[26];
        int[] target = new int[26];
        int size = s1.length();

        for (char ch : s1.toCharArray()) target[ch - 'a']++;
        for (int i = 0; i < size; i++) source[s2.charAt(i) - 'a']++;

        if (isValid(source, target)) return true;
        for (int i = 1; i + size - 1 < s2.length(); i++) {
            source[s2.charAt(i - 1) - 'a']--;
            source[s2.charAt(i + size - 1) - 'a']++;
            if(isValid(source, target)) return true;
        }
        return false;
    }

    private boolean isValid(int[] source, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (source[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}