class Solution {
    // T: O(klogk) loop k times at most
    // S: O(k)
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList(k);
        if (nums1.length * nums2.length == 0 || k == 0) return ans;
        Queue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1]));
        for (int i = 0; i < nums1.length; i++) queue.add(new int[]{nums1[i], nums2[0], 0});
        while (k-- > 0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            ans.add(new int[]{cur[0], cur[1]});
            if (cur[2] + 1< nums2.length) {
                queue.add(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }
        return ans;
    }
}