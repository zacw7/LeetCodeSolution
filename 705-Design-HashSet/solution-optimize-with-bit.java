class MyHashSet {

    private int[] store;

    /** Initialize your data structure here. */
    public MyHashSet() {
        store = new int[125001];
    }

    public void add(int key) {
        int n = key / 8, offset = key % 8;
        store[n] |= (1 << offset);
    }

    public void remove(int key) {
        int n = key / 8, offset = key % 8;
        store[n] &= ~(1 << offset);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int n = key / 8, offset = key % 8;
        return (store[n] & (1 << offset)) > 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */