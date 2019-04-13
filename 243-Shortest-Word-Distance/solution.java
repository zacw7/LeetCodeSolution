class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1;
        int minDist = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                if (p2 != -1) minDist = Math.min(minDist, i - p2);
                p1 = i;
            } else if (words[i].equals(word2)) {
                if (p1 != -1) minDist = Math.min(minDist, i - p1);
                p2 = i;
            }
        }
        return minDist;
    }
}