class AllOne {

    Map<String, Integer> countMap;
    TreeMap<Integer, Set<String>> treeMap;
    /** Initialize your data structure here. */
    public AllOne() {
        this.countMap = new HashMap();
        this.treeMap = new TreeMap();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if (countMap.containsKey(key)) {
            // process the old
            int count = countMap.get(key);
            Set<String> oldSet = treeMap.get(count);
            oldSet.remove(key);
            if (oldSet.isEmpty()) {
                treeMap.remove(count);
            } else {
                treeMap.put(count, oldSet);
            }
            // process the new
            count++;
            countMap.put(key, count);
            Set<String> newSet = treeMap.getOrDefault(count, new HashSet());
            newSet.add(key);
            treeMap.put(count, newSet);
        } else {
            countMap.put(key, 1);
            Set<String> newSet = treeMap.getOrDefault(1, new HashSet());
            newSet.add(key);
            treeMap.put(1, newSet);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (countMap.containsKey(key)) {
            // process the old
            int count = countMap.get(key);
            Set<String> oldSet = treeMap.get(count);
            oldSet.remove(key);
            if (oldSet.isEmpty()) {
                treeMap.remove(count);
            } else {
                treeMap.put(count, oldSet);
            }
            // process the new
            count--;
            if (count > 0) {
                countMap.put(key, count);
                Set<String> newSet = treeMap.getOrDefault(count, new HashSet());
                newSet.add(key);
                treeMap.put(count, newSet);
            } else {
                countMap.remove(key);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (treeMap.isEmpty()) {
            return "";
        }
        Set<String> set = treeMap.get(treeMap.lastKey());
        for (String s : set) {
            return s;
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (treeMap.isEmpty()) {
            return "";
        }
        Set<String> set = treeMap.get(treeMap.firstKey());
        for (String s : set) {
            return s;
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */