class Solution {
    // T: O(n*m*lognm)
    // S: O(nm)
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList();
        Queue<int[]> queue = new PriorityQueue<int[]>((o1, o2) -> (o1[0] + o1[1]) - (o2[0] + o2[1]));
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                queue.add(new int[]{n1, n2});
            }
        }
        while (k-- > 0 && !queue.isEmpty()) ans.add(queue.poll());
        return ans;
    }
}