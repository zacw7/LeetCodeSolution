class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] keyPos = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            keyPos[keyboard.charAt(i) - 'a'] = i;
        }
        int res = 0, cur = 0;
        for (char c : word.toCharArray()) {
            res += Math.abs(cur - keyPos[c - 'a']);
            cur = keyPos[c - 'a'];
        }
        return res;
    }
}