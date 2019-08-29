class LFUCache {

    private int capacity, minFreq;
    private Map<Integer, Integer> valueMap;
    private Map<Integer, Integer> freqMap;
    private Map<Integer, LinkedHashSet<Integer>> setMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.valueMap = new HashMap();
        this.freqMap = new HashMap();
        this.setMap = new HashMap();
    }

    public int get(int key) {
        if (!valueMap.containsKey(key)) {
            return -1;
        } else {
            touch(key);
            return valueMap.get(key);
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (valueMap.containsKey(key)) {
            valueMap.put(key, value);
            touch(key);
            return;
        }
        if (valueMap.size() == capacity) {
            LinkedHashSet<Integer> minSet = setMap.get(minFreq);
            int rm = minSet.iterator().next();
            minSet.remove(rm);
            valueMap.remove(rm);
        }
        freqMap.put(key, 0);
        valueMap.put(key, value);
        touch(key);
    }

    private void touch(int key) {
        int freq = freqMap.getOrDefault(key, 0);
        if (freq > 0) {
            LinkedHashSet<Integer> old = setMap.get(freq);
            old.remove(key);
            if (minFreq == freq && old.isEmpty()) {
                minFreq++;
            }
        } else {
            minFreq = 1;
        }
        freq++;
        freqMap.put(key, freq);
        LinkedHashSet<Integer> cur = setMap.getOrDefault(freq, new LinkedHashSet());
        cur.add(key);
        setMap.put(freq, cur);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */