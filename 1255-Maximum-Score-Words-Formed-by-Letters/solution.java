class Solution {
    int max;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        int[] wordScore = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordScore[i] = getWordScore(words[i], score);
        }
        max = 0;
        dfs(count, words, wordScore, 0, 0);
        return max;
    }

    private void dfs(int[] count, String[] words, int[] wordScore, int i, int cur) {
        for (int c : count) {
            if (c < 0) {
                return;
            }
        }
        max = Math.max(cur, max);
        if (i >= words.length) {
            return;
        }
        dfs(count, words, wordScore, i + 1, cur);

        for (char c : words[i].toCharArray()) {
            count[c - 'a']--;
        }
        dfs(count, words, wordScore, i + 1, cur + wordScore[i]);
        for (char c : words[i].toCharArray()) {
            count[c - 'a']++;
        }
    }

    private int getWordScore(String word, int[] score) {
        int sum = 0;
        for (char c : word.toCharArray()) {
            sum += score[c - 'a'];
        }
        return sum;
    }
}