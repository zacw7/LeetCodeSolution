class LRUCache {

    class Cache {
        int id, val;
        Cache prev, next;
        Cache(int id, int val) {
            this.id = id;
            this.val = val;
        }
    }

    private Cache head;
    private Map<Integer, Cache> cacheMap;
    private int MAX_CAPACITY, capacity;

    public LRUCache(int capacity) {
        this.MAX_CAPACITY = capacity;
        this.cacheMap = new HashMap();
        this.capacity = 0;
        this.head = new Cache(-1, 0);
    }

    public int get(int key) {
        if (cacheMap.containsKey(key)) {
            Cache cache = cacheMap.get(key);
            removeCache(cache);
            if (head.next != null) head.next.prev = cache;
            cache.next = head.next;
            cache.prev = head;
            head.next = cache;
            return cache.val;
        } else return -1;
    }

    public void put(int key, int value) {
        if (MAX_CAPACITY == 0) return;
        Cache nCache = new Cache(key, value);
        if (cacheMap.containsKey(key)) {
            removeCache(cacheMap.get(key));
            cacheMap.remove(key);
            capacity--;
        } else if (capacity >= MAX_CAPACITY) {
            Cache prev = head, last = prev.next;
            while (last.next != null) {
                prev = last;
                last = last.next;
            }
            prev.next = null;
            cacheMap.remove(last.id);
            capacity--;
        }
        cacheMap.put(key, nCache);
        if (head.next != null) head.next.prev = nCache;
        nCache.next = head.next;
        nCache.prev = head;
        head.next = nCache;
        capacity++;
    }

    private void removeCache(Cache cache) {
        if (cacheMap.containsKey(cache.id)) {
            Cache prev = cache.prev;
            if (cache.next != null) cache.next.prev = prev;
            prev.next = cache.next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */