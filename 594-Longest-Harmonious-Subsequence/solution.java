class Solution {
    public int findLHS(int[] nums) {
        if (nums.length <= 1) return 0;
        Map<Integer, Integer> numCount = new HashMap();
        for (int n : nums) numCount.put(n, numCount.getOrDefault(n, 0) + 1);
        List<Integer> numList = new ArrayList(numCount.keySet());
        Collections.sort(numList);
        int max = 0;
        for (int i = 1, size = numList.size(); i < size; i++) {
            int cur = 0;
            if (numList.get(i) - numList.get(i - 1) <= 1) {
                cur = numCount.get(numList.get(i)) + numCount.get(numList.get(i - 1));
            }
            if (cur > max) max = cur;
        }
        return max;
    }
}