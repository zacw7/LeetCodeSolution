class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap();
        for (String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }
        List<String> ans = new ArrayList(wordCount.keySet());
        Collections.sort(ans, (o1, o2) -> {
            if (wordCount.get(o1) == wordCount.get(o2)) {
                return o1.compareTo(o2);
            } else {
                return wordCount.get(o2) - wordCount.get(o1);
            }
        });
        return ans.subList(0, k);
    }
}