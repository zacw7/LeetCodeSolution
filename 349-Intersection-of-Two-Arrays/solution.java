class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = new HashSet();
        Set<Integer> intersNum = new HashSet();
        for (int n : nums1) {
            nums1Set.add(n);
        }
        for (int n : nums2) {
            if (nums1Set.contains(n)) {
                intersNum.add(n);
            }
        }
        int size = intersNum.size();
        int[] ans = new int[size];
        int i = 0;
        for (Integer num : intersNum) {
            ans[i++] = num;
        }
        return ans;
    }
}