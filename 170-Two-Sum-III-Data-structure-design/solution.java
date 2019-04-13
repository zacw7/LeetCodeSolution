class TwoSum {

    private List<Integer> nums;

    /** Initialize your data structure here. */
    public TwoSum() {
        this.nums = new ArrayList();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        nums.add(number);
        Collections.sort(nums);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int lo = 0, hi = nums.size() - 1;
        while (lo < hi) {
            int sum = nums.get(lo) + nums.get(hi);
            if (sum == value) return true;
            else if (sum < value) lo++;
            else hi--;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */