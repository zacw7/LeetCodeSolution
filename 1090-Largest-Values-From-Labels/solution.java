class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        Map<Integer, Integer> valueMap = new HashMap();
        Map<Integer, Integer> labelMap = new HashMap();
        Integer[] idx = new Integer[values.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
            valueMap.put(i, values[i]);
            labelMap.put(i, labels[i]);
        }
        Arrays.sort(idx, (a, b) -> valueMap.get(b) - valueMap.get(a));
        System.out.println(Arrays.toString(idx));
        int sum = 0, num = 0;
        Map<Integer, Integer> useCount = new HashMap();
        for (int i : idx) {
            int value = valueMap.get(i), label = labelMap.get(i);
            int count = useCount.getOrDefault(label, 0);
            if (count < use_limit) {
                sum += value;
                num++;
                useCount.put(label, count + 1);
            }
            if (num >= num_wanted) break;
        }
        return sum;
    }
}