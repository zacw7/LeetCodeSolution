class Solution {
    public int missingNumber(int[] arr) {
        int N = arr.length;
        Map<Integer, Integer> count = new HashMap();
        for (int i = 0; i < N - 1; i++) {
            int val = arr[i + 1] - arr[i];
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getKey();
            }
            if (entry.getValue() < min) {
                min = entry.getKey();
            }
        }
        int diff = max;
        if (max == min * 2) {
            diff = min;
        }
        if (diff == 0) {
            return arr[0];
        }
        for (int i = 0; i < N - 1; i++) {
            int val = arr[i + 1] - arr[i];
            if (val != diff) {
                return arr[i] + diff;
            }
        }
        return -1;
    }
}