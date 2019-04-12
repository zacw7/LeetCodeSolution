class Solution {
    // T: O(2n + nlogn) = O(nlogn)
    // S: O(m) m is the distinct numbers
    public boolean isPossible(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);
        while (!map.isEmpty()) {
            int idx = map.firstKey();
            int count = map.get(idx) - 1;
            int offset = 1;
            int max = count;
            while (map.containsKey(idx + offset)) {
                int c = map.getOrDefault(idx + offset, 0) - 1;
                max = Math.max(max, c);
                if (c < max) break;
                if (c == 0) map.remove(idx+ offset);
                else map.put(idx + offset, c);
                offset++;
            }
            if (offset < 3) return false;
            if (count == 0) map.remove(idx);
            else map.put(idx, count);
        }
        return true;
    }
}