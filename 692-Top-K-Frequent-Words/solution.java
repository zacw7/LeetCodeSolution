class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList();
        Map<String, Word> map = new HashMap();
        for (String w : words) {
            Word word;
            if (map.containsKey(w)) word = map.get(w);
            else word = new Word(w);
            word.addFreq();
            map.put(w, word);
        }
        Queue<Word> queue
                = new PriorityQueue<Word>((o1, o2) -> (o2.freq == o1.freq) ? o1.val.compareTo(o2.val) : o2.freq - o1.freq);
        for (Word w : map.values()) queue.add(w);
        while (k-- > 0) ans.add(queue.poll().val);
        return ans;
    }

    class Word {
        String val;
        int freq;
        Word(String val) {
            this.val = val;
            this.freq = 0;
        }
        void addFreq() {
            this.freq++;
        }
    }
}