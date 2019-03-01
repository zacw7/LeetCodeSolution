class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        String[] words = (A + " " + B).split(" ");
        Map<String, Integer> wordCount = new HashMap();
        for (String word : words) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        List<String> distinctWords = new ArrayList();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue().equals(1)) distinctWords.add(entry.getKey());
        }
        return distinctWords.toArray(new String[distinctWords.size()]);
    }
}