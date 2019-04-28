class RandomizedSet {

    private List<Integer> nums;
    private Map<Integer, Integer> idxMap;
    private Random rand = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.nums = new ArrayList();
        this.idxMap = new HashMap();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (idxMap.containsKey(val)) {
            return false;
        }
        idxMap.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!idxMap.containsKey(val)) {
            return false;
        }
        int idx = idxMap.get(val);
        if (idx < nums.size() - 1) {
            nums.set(idx, nums.get(nums.size()  - 1));
            idxMap.put(nums.get(idx), idx);
        }
        nums.remove(nums.size() - 1);
        idxMap.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */