class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> wordCount = new HashMap();
        String[] words = paragraph.toLowerCase().replaceAll("[^a-z]", " ").replaceAll("[ ]+", " ").split(" ");
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (String word : banned) {
            wordCount.put(word, -1);
        }
        int maxCount = -1;
        String mostCommonWord = "";
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) > maxCount) {
                maxCount = wordCount.get(word);
                mostCommonWord = word;
            }
        }
        return mostCommonWord;
    }
}