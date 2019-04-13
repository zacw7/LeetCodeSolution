class WordDistance {

    private Map<String, List<Integer>> idxMap;

    public WordDistance(String[] words) {
        this.idxMap = new HashMap();
        for (int i = 0; i < words.length; i++) {
            List<Integer> idxList = idxMap.getOrDefault(words[i], new ArrayList());
            idxList.add(i);
            idxMap.put(words[i], idxList);
        }
    }

    public int shortest(String word1, String word2) {
        if (!idxMap.containsKey(word1) || !idxMap.containsKey(word2)) return -1;
        List<Integer> idxList1 = idxMap.get(word1);
        List<Integer> idxList2 = idxMap.get(word2);
        int minDist = Integer.MAX_VALUE;
        for (int i : idxList1) {
            for (int j : idxList2) {
                minDist = Math.min(minDist, Math.abs(i - j));
            }
        }
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */