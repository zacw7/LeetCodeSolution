class Solution {
    // T: O(nlogn + n)
    // S: O(n)
    public String longestWord(String[] words) {
        Arrays.sort(words, (w1, w2) -> w1.length() - w2.length());
        Set<String> dict = new HashSet();
        String longestWord = "";
        for (String w : words) {
            if (w.length() == 1 || dict.contains(w.substring(0, w.length() - 1))) {
                dict.add(w);
                if (w.length() > longestWord.length()
                        || (w.length() == longestWord.length() && w.compareTo(longestWord) < 0)) {
                    longestWord = w;
                }
            }
        }
        return longestWord;
    }
}