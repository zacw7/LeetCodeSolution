class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet();
        for (int n1 : nums1) {
            seen.add(n1);
        }
        List<Integer> in = new ArrayList();
        for (int n2 : nums2) {
            if (seen.contains(n2)) {
                in.add(n2);
                seen.remove(n2);
            }
        }
        int[] res = new int[in.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = in.get(i);
        }
        return res;
    }
}