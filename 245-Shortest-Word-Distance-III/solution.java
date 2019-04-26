class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int dist = words.length;
        if (word1.equals(word2)) {
            int prev = -1;
            for (int i = 0; i < words.length; i++) {
                if (word1.equals(words[i])) {
                    if (prev > -1) {
                        dist = Math.min(dist, i - prev);
                    }
                    prev = i;
                }
            }
        } else {
            int prev1 = -1, prev2 = -1;
            for (int i = 0; i < words.length; i++) {
                if (word1.equals(words[i])) {
                    if (prev2 > -1) {
                        dist = Math.min(dist, i - prev2);
                    }
                    prev1 = i;
                } else if (word2.equals(words[i])) {
                    if (prev1 > -1) {
                        dist = Math.min(dist, i - prev1);
                    }
                    prev2 = i;
                }
            }
        }
        return dist;
    }
}