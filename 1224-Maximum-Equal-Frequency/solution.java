class Solution {
    public int maxEqualFreq(int[] nums) {
        int maxLen = 1;
        Map<Integer, Integer> numToFreq = new HashMap();
        Map<Integer, Set<Integer>> freqToNums = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int freq = numToFreq.getOrDefault(nums[i], 0);
            if (freq > 0) {
                Set<Integer> set = freqToNums.get(freq);
                set.remove(nums[i]);
                if (set.isEmpty()) {
                    freqToNums.remove(freq);
                }
            }
            freq += 1;
            numToFreq.put(nums[i], freq);
            Set<Integer> set = freqToNums.getOrDefault(freq, new HashSet());
            set.add(nums[i]);
            freqToNums.put(freq, set);
            if (numToFreq.size() == 1) {
                maxLen = i + 1;
            } else if (freqToNums.size() == 1 && freqToNums.containsKey(1)) {
                maxLen = i + 1;
            } else if (freqToNums.size() == 2) {
                if (freqToNums.containsKey(1) && freqToNums.get(1).size() == 1) {
                    maxLen = i + 1;
                } else {
                    int max = 0, min = nums.length;
                    for (int k : freqToNums.keySet()) {
                        max = Math.max(max, k);
                        min = Math.min(min, k);
                    }
                    if (max - min == 1 && freqToNums.get(max).size() == 1) {
                        maxLen = i + 1;
                    }
                }
            }
        }
        return maxLen;
    }
}