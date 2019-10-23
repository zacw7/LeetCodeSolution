class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int N = s1.length();
        int[] target = new int[26];
        int[] count = new int[26];
        for (int i = 0; i < N; i++) {
            target[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']++;
        }
        if (isValid(count, target)) {
            return true;
        }
        for (int i = N; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a']++;
            count[s2.charAt(i - N) - 'a']--;
            if (isValid(count, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[] count, int[] target) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}