class Solution {
    // Bitmap
    // Time: O(kn + n^2)
    // Space: O(n)
    public int maxProduct(String[] words) {
        int[] lens = new int[words.length];
        int[] bitmap = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            lens[i] = words[i].length();
            for (char c : words[i].toCharArray()) {
                bitmap[i] |= 1 << (c - 'a');
            }
        }
        int maxLen = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitmap[i] & bitmap[j]) == 0) {
                    maxLen = Math.max(maxLen, lens[i] * lens[j]);
                }
            }
        }
        return maxLen;
    }
}