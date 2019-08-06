class Solution {
    public int longestWPI(int[] hours) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                sum++;
            } else {
                sum--;
            }
            if (sum > 0) {
                max = i + 1;
            } else {
                map.putIfAbsent(sum, i);
                max = Math.max(max, i - map.getOrDefault(sum - 1, i));
            }
        }
        return max;
    }
}