class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> countMap = new HashMap();
        for (int b : barcodes) {
            countMap.put(b, countMap.getOrDefault(b, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> countMap.get(o2) - countMap.get(o1));
        queue.addAll(countMap.keySet());
        int[] ans = new int[barcodes.length];
        int add = -1;
        for (int i = 0; i < ans.length; i++) {
            int num = queue.poll();
            if (add >= 0) {
                queue.offer(add);
                add = -1;
            }
            ans[i] = num;
            int c = countMap.get(num) - 1;
            if (c == 0) {
                countMap.remove(num);
            } else {
                countMap.put(num, c);
                add = num;
            }
        }
        return ans;
    }
}