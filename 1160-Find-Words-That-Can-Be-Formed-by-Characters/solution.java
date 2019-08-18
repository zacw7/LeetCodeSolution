class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (char c : chars.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            if (isGood(word, count.clone())) {
                res += word.length();
            }
        }
        return res;
    }

    private boolean isGood(String word, int[] count) {
        for (char c : word.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}